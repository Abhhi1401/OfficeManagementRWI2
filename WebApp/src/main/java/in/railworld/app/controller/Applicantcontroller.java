package in.railworld.app.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.railworld.app.Services.Implemetation.ApplicantService;
import in.railworld.app.controller.dto.ApplicantDTO;
import in.railworld.app.controller.dto.VerifyOtpRequest;
import in.railworld.app.model.Applicant;
import in.railworld.app.service.JobDetailsService;

@RestController
@RequestMapping("/api")
public class Applicantcontroller {

	@Autowired
	private ApplicantService applicantService;

	@Autowired
	private JobDetailsService jobDetailsService;

//    @PostMapping("/applicants")
//    public ResponseEntity<Applicant> createApplicant(@RequestBody Applicant applicant) {
//        Applicant createdApplicant = applicantService.createApplicant(applicant);
//        return new ResponseEntity<>(createdApplicant, HttpStatus.CREATED);
//    }

	@PostMapping("/verify")
	public ResponseEntity<String> verifyOtp(@RequestBody VerifyOtpRequest verifyOtpRequest) {
		boolean isVerified = applicantService.verifyOtp(verifyOtpRequest.getEmail(), verifyOtpRequest.getOtp());

		if (isVerified) {
			return new ResponseEntity<>("OTP verified successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Invalid OTP", HttpStatus.BAD_REQUEST);
		}
	}

	// Create a DTO class for verifying OTP
//    public static class VerifyOtpRequest {
//        private String email;. 
//        private String otp;
//
//        // Getters and setters
//        
//        public String getEmail() {
//            return email;
//        }
//
//        public void setEmail(String email) {
//            this.email = email;
//        }
//
//        public String getOtp() {
//            return otp;
//        }
//
//        public void setOtp(String otp) {
//            this.otp = otp;
//        }
//    }
//    

//    @PostMapping("/{applicantId}/upload-resume")
//    public ResponseEntity<String> uploadResume(@PathVariable Long applicantId,
//                                               @RequestParam("resumeFile") MultipartFile resumeFile) {
//        boolean uploadSuccess = applicantService.uploadResume(applicantId, resumeFile);
//        
//        if (uploadSuccess) {
//            return ResponseEntity.ok("Resume uploaded successfully");
//        } else {
//            return ResponseEntity.badRequest().body("Failed to upload resume");
//        }
//    }

	@DeleteMapping("/{applicantId}/delete")
	public ResponseEntity<String> deleteApplicant(@PathVariable Long applicantId) {
		boolean deleted = applicantService.deleteApplicantById(applicantId);
		if (deleted) {
			return ResponseEntity.ok("Applicant deleted successfully");
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}

//    @PostMapping("/applicants")
//    public ResponseEntity<String> createApplicantAndUploadResume(
//            @ModelAttribute Applicant applicant,
//            @RequestParam("resumeFile") MultipartFile resumeFile) {
//        return applicantService.createApplicantAndUploadResume(applicant, resumeFile);
//    }


    
//    @PostMapping("/applicants")
//    public ResponseEntity<String> createApplicantAndUploadResume(
//            @RequestParam("applicantData") String applicantData,
//            @RequestParam("resumeFile") MultipartFile resumeFile) {
//        
//        try {
//            // Deserialize JSON string to Applicant object using ObjectMapper
//            ObjectMapper objectMapper = new ObjectMapper();
//            Applicant applicant = objectMapper.readValue(applicantData, Applicant.class);
//            
//            return applicantService.createApplicantAndUploadResume(applicant, resumeFile);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid JSON data: " + e.getMessage());
//        }
//    }
    
    
//    @PostMapping("/applicant")
//    public ResponseEntity<String> createApplicant(@ModelAttribute ApplicantDTO applicantDTO) throws IOException, IllegalStateException, java.io.IOException {
//        // Call the service method to create an applicant, which will handle the file upload.
//        return applicantService.createApplicant(applicantDTO);
//        }



//	@PostMapping(value = "/applicants", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//	public ResponseEntity<String> createApplicantAndUploadResume(
//			@RequestParam(value = "applicantData", required = false) String applicantData,
//			@RequestPart(value = "resumeFile", required = false) MultipartFile resumeFile) {
//		System.out.println(applicantData);
//		System.out.println(resumeFile);

//		try {
//			// Deserialize JSON string to Applicant object using ObjectMapper
////			ObjectMapper objectMapper = new ObjectMapper();
////			Applicant applicant = objectMapper.readValue(applicantData, Applicant.class);
//
//			return applicantService.createApplicantAndUploadResume(applicantData, resumeFile);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid JSON data: " + e.getMessage());
//		}
//		return null;
//	}
	
	
	
	@PostMapping(value = "/applicants", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)    
	 public ResponseEntity<String> createApplicantAndUploadResume(
            @RequestParam("applicantData") String applicantData,
            @RequestPart("resumeFile") MultipartFile resumeFile) {
        try {
            // Deserialize JSON string to Applicant object using ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();
            Applicant applicant = objectMapper.readValue(applicantData, Applicant.class);
            return applicantService.createApplicantAndUploadResume(applicant, resumeFile);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid JSON data: " + e.getMessage());
        }
    }
	
    @GetMapping("/applicantlist")
    public ResponseEntity<List<Applicant>> getAllApplicants() {
    	
        List<Applicant> applicants = applicantService.getAllApplicants();
        return ResponseEntity.ok(applicants);
    }







	@PostMapping("/resend-otp")
	public ResponseEntity<String> resendOtp(@RequestParam String email) {
		try {
			applicantService.resendOtp(email);
			return ResponseEntity.ok("OTP resent successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}