package in.railworld.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import in.railworld.app.controller.dto.AllEmpsResponse;
import in.railworld.app.controller.dto.LeaveRequestDto;
import in.railworld.app.controller.dto.Response;
import in.railworld.app.model.Address;
import in.railworld.app.model.Employee;
import in.railworld.app.model.LeaveRequest;
import in.railworld.app.service.EmployeeService;

import in.railworld.app.service.JobDetailsService;
import jakarta.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private LeaveServiceImpl leaveservice;
	
	
	
	//create user-->POST mapping
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Employee employee){
		Employee createdEmployee = employeeService.employeeRegister(employee);
		if (createdEmployee != null) {
            return ResponseEntity.ok("Employee created successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create employee.");
        }
	}
	
	//delete user -->DELETE Mapping
	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int employeeId){
		employeeService.deleteEmployeeById(employeeId);
		return ResponseEntity.ok("employee Deleted");
		
		}
	//update user --> PUT Mapping
	@PutMapping("/update/{employeeid}")
	public ResponseEntity<Employee> updateEmployeeInfo(@RequestBody Employee employee, @PathVariable int employeeId){
		
		Employee updatedEmp = employeeService.updateEmployeeDetails(employee, employeeId);
		return ResponseEntity.ok(updatedEmp);
		
	}
	//get user --> GET Mapping
	
//	@GetMapping("/login/{email}/{password}")
//	public ResponseEntity<String> loginEmployee(@PathVariable String email, @PathVariable String password){

//		Optional<Employee> employee = employeeService.findByEmail(email);

//		if(employee != null && employee.getPassword().equals(password)) {
//			
//			return ResponseEntity.ok("Login Successful !");
//		}
//		else {
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
//		}
//	}


	//register address --> POST Mapping
	    
	    @PostMapping("/{employeeId}/address")
	    public ResponseEntity<String> createAddressForEmployee(@PathVariable int employeeId, @RequestBody Address addressDetails) {
	        String response = employeeService.createAddressForEmployee(employeeId, addressDetails);
	        
	        if ("Employee not found".equals(response)) {
	            return ResponseEntity.notFound().build();
	        } else {
	            return ResponseEntity.ok(response);
	        }
	    }
	    
	  //delete address by empid --> POST Mapping
	    
	    @DeleteMapping("/{employeeId}/address/{addressId}")
	    public ResponseEntity<String> deleteAddressByEmployeeId(@PathVariable int employeeId, @PathVariable int addressId) {
	        employeeService.deleteAddressByEmployeeId(employeeId, addressId);
	        return ResponseEntity.ok("Address deleted successfully for Employee ID: " + employeeId);
	    }
//	    @PostMapping("/applyForLeave")
//	    public ResponseEntity<String> ApplyForLeave(@RequestBody LeaveRequestDto leaveRequestDto){
//	    	try {
//	    		Employee employee=employeeService.getEmployeeById(leaveRequestDto.getEmployeeId());
//	    		if(employee == null) {
//	    			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("employee not Found with id :" +leaveRequestDto.getEmployeeId());
//	    		}
//	    		
//	    		//create a leave request
//	    		
//	    		LeaveRequest leaveRequest= new LeaveRequest();
//	    		leaveRequest.setStartDate(leaveRequestDto.getStartDate());
//	    		leaveRequest.setEndDate(leaveRequestDto.getEndDate());
//	    		leaveRequest.setReason(leaveRequestDto.getReason());
//	    		leaveRequest.setEmployee(employee);
//	    		
//	    		//save the leave request
//	    		
//	    		LeaveRequest savedRequest =leaveservice.applyForLeave(leaveRequest);
//	    		return ResponseEntity.ok("Leave request submitted with id :" + savedRequest.getId());
//	    		
//	    	} catch(Exception e) {
//	    		e.printStackTrace();
//	    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//	    	}
//	    	
//	    }
	    
	    
	    @PostMapping(path = "/ApplyforLeave", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
		public ResponseEntity<Response<LeaveRequest>> CreateLeaveRequest(
//				@RequestParam("StartDate") String StartDate,
//				@RequestParam("endDate") String endDate,
//				@RequestParam("reason") String reason,
				@RequestParam("leaveRequestDto") String l1, @RequestParam MultipartFile attachement,
				HttpServletResponse res){
			    
				
				try {
				
				        
				       
				           ObjectMapper mapper = new ObjectMapper();
				           LeaveRequestDto leaveRequestDto =    mapper.readValue(l1, LeaveRequestDto.class);
				      System.out.println(l1);
				    if(attachement != null) {
				    	   
				    	System.out.println("got the file"+ attachement.getSize());
				    }
				LeaveRequest savedLeave = leaveservice.CreateLeaveRequest(leaveRequestDto, attachement);
				//LeaveRequestDto leaveRequestDto=new LeaveRequestDto(StartDate,endDate,reason,attachement);
				 if(savedLeave!= null) {
			    	           
			    	       Response<LeaveRequest>  rL =  new Response("sucess",  res.getHeader("Authorization"), true, savedLeave);
			   
			        return  ResponseEntity.status(HttpStatus.ACCEPTED)
			        		              .body(rL);
			        		              
			     }
				 throw new RuntimeException("Leave request could not be created");

				
				
				
				
			}catch(Exception e){
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
				
			}
	}
