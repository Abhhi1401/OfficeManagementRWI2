package in.railworld.app.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;


import in.railworld.app.Services.Implemetation.LeaveServiceImpl;
import in.railworld.app.Services.Implemetation.ProjectService;
import in.railworld.app.config.JwtService;
import in.railworld.app.controller.dto.AllEmpsResponse;
import in.railworld.app.controller.dto.AuthRequest;
import in.railworld.app.controller.dto.EmployeeDto;
import in.railworld.app.controller.dto.EmployeeProjectDetailDTO;
import in.railworld.app.controller.dto.EmployeeReqDto;
import in.railworld.app.controller.dto.EmployeeResponse;

import in.railworld.app.controller.dto.LeaveRequestDto;

import in.railworld.app.controller.dto.ResponseDto;

import in.railworld.app.controller.model.EmailRequest;
import in.railworld.app.model.CustomResponse;
import in.railworld.app.model.EmailConfig;
import in.railworld.app.model.HR;
import in.railworld.app.model.LeaveRequest;
import in.railworld.app.model.Project;
import in.railworld.app.model.UserInfo;
import in.railworld.app.service.EmailService;
import in.railworld.app.service.EmployeeService;
import in.railworld.app.service.HRService;
import in.railworld.app.service.JobDetailsService;
import in.railworld.app.service.UserService;
import in.railworld.app.util.EmailConfigService;
import jakarta.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/HR")
public class HRController {
	
	 @Autowired
     private ObjectMapper objectMapper;
	
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
    private JwtService jwtService;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	private HRService hrService;
	
	@Autowired
	private JobDetailsService jobDetailsService;
	

    @Autowired
    private UserService userService;
    
    @Autowired
    private PasswordEncoder encoder;
    
    @Autowired
    private ProjectService projectService;
	
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmailConfigService emailConfigService;
	
	@Autowired
	private LeaveServiceImpl leaveService;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody HR hr){
		HR createdHr = hrService.HrRegister(hr);
		if (createdHr != null) {
            return ResponseEntity.ok("Hr created successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create employee.");
        }
	}
	
	
	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int employeeId){
		employeeService.deleteEmployeeById(employeeId);
		return ResponseEntity.ok("employee Deleted");
		
		}
	
//	@PostMapping("/send_Email")
	//public String SendEmail(@RequestBody EmailRequest emailrequest) {
		
		//String employeeEmail = emailrequest.getEmployeeEmail();
		//String subject = emailrequest.getSubject();
		//String content = emailrequest.getContent();
		 //emailService.sendEmail(employeeEmail, subject, content);
		 
		//return" email sent successfully to:"+employeeEmail;
		
	//}
	
//	@PostMapping("/bulk")
//	public ResponseEntity<String> SendBulkEmail(@RequestBody BulkEmailDto bulkemail){
//		try {
//			emailService.SendBulkEmail(bulkemail);
//			return ResponseEntity.ok("Bulk email sent successfully!");
//			
//		}catch(Exception e) {
//			
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed to send bulk email");
//			
//		}
//		
//	}
	
	@PostMapping("/sendbulkmail")
    public ResponseEntity<String> sendEmail(
            @RequestParam("id") Long id,
            @RequestParam("toEmails") List<String> toEmails,
            @RequestBody EmailRequest emailRequest) {

        try {
            ResponseEntity<String> response = emailService.sendmail(id, toEmails, emailRequest);
            return response;
        } catch (Exception ex) {
            // Handle exceptions and return a Bad Request (400) response
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to send email: " + ex.getMessage());
        }
    }
	
	
	// setting sender email
	  @PostMapping("/set/email")
	  public ResponseEntity<String>  setSenderEmailHandler(@RequestBody EmailConfig emailConfig){
		     
		   
		  return ResponseEntity.status(HttpStatus.CREATED).body( emailConfigService.setEmailConfiguration(emailConfig));
	  }
	
//	  @PostMapping("/job/adddetails")
//	    public ResponseEntity<JobDetails> createJob(@RequestBody JobDetails jobDetails) {
//	        JobDetails createdJob = jobDetailsService.createJob(jobDetails);
//	        return ResponseEntity.status(HttpStatus.CREATED).body(createdJob);
//	    }
//	  
	  @DeleteMapping("/job/delete/{jobId}")
	    public ResponseEntity<Void> deleteJob(@PathVariable int jobId) {
	        jobDetailsService.deleteJob(jobId);
	        return ResponseEntity.noContent().build();
	    }
	  
	  @PostMapping("/adduser")
	    public String addUser(@RequestBody UserInfo userInfo) {
		  userInfo.setPassword(encoder.encode(userInfo.getPassword()));
	        // Call the service to add the user
	        userService.addUser(userInfo);
	        return "User added successfully";
	    }
	  
       // login  
	    
	  @PostMapping("/login")
	    public ResponseEntity<CustomResponse> generateToken(@RequestBody AuthRequest authRequest) {
	        try {
	            Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getPassword()));
	            if (auth.isAuthenticated()) {
	                String token = jwtService.generateToken(authRequest.getName());

	                // Set the token in the request header
	                HttpHeaders headers = new HttpHeaders(); 
	                headers.add("Authorization", "Bearer " + token);

	                // Create a custom response object with status, message, and boolean
	                CustomResponse response = new CustomResponse("success", "Authentication successful", true, token);

	                // Return the custom response along with the headers
	                return ResponseEntity.ok().headers(headers).body(response);
	            } else {
	                throw new UsernameNotFoundException("There is no user with this name");
	            }
	        } catch (Exception e) {
	            // Handle any exceptions here and return an appropriate response
	            CustomResponse errorResponse = new CustomResponse("error", e.getMessage(), false, null);
	            return ResponseEntity.badRequest().body(errorResponse);
	        }
	  
//	  @PostMapping("/login")
//	  public ResponseEntity<String> generateTokenAndRedirect(@RequestBody AuthRequest authRequest, HttpServletRequest req, HttpServletResponse response) {
//	      try {
//	          Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getPassword()));
//	          if (auth.isAuthenticated()) {
//	              String token = jwtService.generateToken(authRequest.getName());
//
//	              // Set the token in the response header for the client to use in subsequent requests
//	              response.setHeader("Authorization", "Bearer " + token);
//                  req.set0
//	              // Perform the redirection to the desired endpoint
//	              
//	                System.out.println(response.getHeader("Authorization"));
//	              response.sendRedirect("http://localhost:8080/jobs/html/dashboard");
//
//	              // Return a redirect status code (302) to instruct the client to redirect
//	              return ResponseEntity.status(HttpStatus.FOUND).body("Redirecting...");
//	          } else {
//	              throw new UsernameNotFoundException("There is no user with this name");
//	          }
//	      } catch (Exception e) {
//	          // Handle any exceptions here and return an appropriate response
//	          e.printStackTrace();
//	          return ResponseEntity.badRequest().body("Error processing request");
//	      }
//	  }

	        
	           
	  
	   
	    }
	  
	  
	  @GetMapping("/emps")
      public ResponseEntity<AllEmpsResponse> getAllEmpsHandler(HttpServletResponse res){
      	
      	 // service employeeSerives; 
		     List<EmployeeResponse> emps =   employeeService.getAllEmployee();
		     
		     if(emps != null) {
		    	    
		    	   AllEmpsResponse aer = new AllEmpsResponse("SUCCESS", res.getHeader("Authorization"), "Here is the list of employee", emps);
		   
		        return  ResponseEntity.status(HttpStatus.ACCEPTED)
		        		              .body(aer);
		        		              
		     }
		  
		  
		  return null;
      	
      }
	  
	  
	    @PostMapping("/add")
	    public Project addProject(@RequestBody Project project) {
	        return projectService.addProject(project);
	    }
	    
	    @GetMapping("/{projectId}")
	    public Optional<Project> getProjectById(@PathVariable int projectId) {
	        return projectService.getProjectById(projectId);
	    }
	    
	    @GetMapping("/all")
	    public Iterable<Project> getAllProjects() {
	        return projectService.getAllProjects();
	    }
	    
	    @PostMapping("/{projectId}/assign/{employeeId}")
	    public Project assignEmployeeToProject(@PathVariable int projectId, @PathVariable int employeeId) {
	        return projectService.assignEmployeeToProject(projectId, employeeId);
	    }
	    
	    @GetMapping("/alls")
	    
	    public ResponseEntity<List<EmployeeProjectDetailDTO>> getAllEmployeeProjectDetails() {
	        List<EmployeeProjectDetailDTO> details = projectService.getEmployeeProjectDetails();
	        return ResponseEntity.status(HttpStatus.OK).body(details);
	    }
	    
	    

//	    @PostMapping(path = "/leaverequest", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
//		public ResponseEntity<LeaveRequestDto> CreateLeaveRequest(
////				@RequestParam("StartDate") String StartDate,
////				@RequestParam("endDate") String endDate,
////				@RequestParam("reason") String reason,
//				@RequestParam("leaveRequestDto") String l1, @RequestParam MultipartFile attachement,
//				HttpServletResponse res){
//			try {     
//				       LeaveRequestDto leaveRequestDto =  new LeaveRequestDto();
//				      System.out.println(l1);
//				    if(attachement != null) {
//				    	   
//				    	System.out.println("got the file"+ attachement.getSize());
//				    }
//				LeaveRequest savedLeave = leaveService.CreateLeaveRequest(leaveRequestDto, attachement);
//				//LeaveRequestDto leaveRequestDto=new LeaveRequestDto(StartDate,endDate,reason,attachement);
//				return ResponseEntity.ok(leaveRequestDto);
//				
//				
//				
//			}catch(Exception e){
//				e.printStackTrace();
//				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//	        }
//				
//			}
	    

	    @PostMapping("/approveLeave/{leaveRequestId}")
	    public ResponseEntity<String> approveLeaveRequest(@PathVariable Long leaveRequestId) {
	        LeaveRequest approvedRequest = leaveService.approveLeaveRequest(leaveRequestId);
	        return ResponseEntity.ok("Leave request approved for ID: " + approvedRequest.getId());
	    }
	


	    
	    // dumy user as HR
	    @PostMapping("/hr")
	    public ResponseEntity<ResponseDto>  addHr(@RequestBody EmployeeReqDto eRD){
	    	
	    	   // save database 
	    	      eRD.setPassword(encoder.encode(eRD.getPassword()));
	    	
	    	    String result =   hrService.addEmployee(eRD);
	    	    
	    	
	    	return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(result, result, result, true));
	    }
	    
	    
	    
//	    @PostMapping(value = "/addemp", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//	    public ResponseEntity<ResponseDto> addEmployee(
//	            @RequestBody EmployeeDto employeeDto,
//	            @RequestParam("photo") MultipartFile photo
//	    ) {
//	        try {
//	            // Call the service to add the employee with the photo
//	            String result = employeeService.addEmployee(employeeDto, photo);
//
//	            // Return a success response
//	            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(result, result, result, true));
//	        } catch (IOException e) {
//	            // Handle the exception appropriately (e.g., log it or return an error response)
//	            e.printStackTrace();
//	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Error occurred", "Error occurred", "Error occurred", false));
//	        }
//	    }
	    
	    
	    
	    @PostMapping(value = "/addemp", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	    public ResponseEntity<ResponseDto> addEmployee(
	            @RequestParam("employeeDto") String employeeDtoJson,
	            @RequestParam("photo") MultipartFile photo
	    ) {
	        try {
	            // Convert the JSON string to EmployeeDto
	            ObjectMapper objectMapper = new ObjectMapper();
	            EmployeeDto employeeDto = objectMapper.readValue(employeeDtoJson, EmployeeDto.class);

	            // Call the service to add the employee with the photo
	            String result = employeeService.addEmployee(employeeDto, photo);

	            // Return a success response
	            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(result, result, result, true));
	        } catch (IOException e) {
	            // Handle the exception appropriately (e.g., log it or return an error response)
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Error occurred", "Error occurred", "Error occurred", false));
	        }
	        
	        
	        
	     
	    	    
	    }
	    
	    @PutMapping("/{employeeId}")
	    public ResponseEntity<ResponseDto> updateEmployee(
	            @PathVariable int employeeId,
	            @ModelAttribute EmployeeDto updatedEmployeeDto,
	            @RequestParam(value = "photo", required = false) MultipartFile updatedPhoto
	    ) {
	        try {
	            // Call the service to update the employee
	            String result = employeeService.updateEmployee(employeeId, updatedEmployeeDto, updatedPhoto);

	            // Return a success response
	            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(result, result, result, true));
	        } catch (IOException e) {
	            // Handle the exception appropriately (e.g., log it or return an error response)
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Error occurred", "Error occurred", "Error occurred", false));
	        }
	    }
	    
	    
}
		
		
		
		
	
