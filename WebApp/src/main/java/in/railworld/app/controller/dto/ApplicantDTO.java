package in.railworld.app.controller.dto;

import org.springframework.web.multipart.MultipartFile;

import in.railworld.app.model.Applicant;

import org.springframework.web.multipart.MultipartFile;

import in.railworld.app.model.Applicant;
import jakarta.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import in.railworld.app.model.Applicant;
import jakarta.persistence.Transient;

public class ApplicantDTO {
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String conDet;
	    private String qualDetails;
	    private String passYear;
	    private String otp;
	    
		@Transient
	    private MultipartFile resumeFile;

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getConDet() {
			return conDet;
		}

		public void setConDet(String conDet) {
			this.conDet = conDet;
		}

		public String getQualDetails() {
			return qualDetails;
		}

		public void setQualDetails(String qualDetails) {
			this.qualDetails = qualDetails;
		}

		public String getPassYear() {
			return passYear;
		}

		public void setPassYear(String passYear) {
			this.passYear = passYear;
		}

		public String getOtp() {
			return otp;
		}

		public void setOtp(String otp) {
			this.otp = otp;
		}

		public MultipartFile getResumeFile() {
			return resumeFile;
		}

		public void setResumeFile(MultipartFile resumeFile) {
			this.resumeFile = resumeFile;
		}

		public ApplicantDTO(String firstName, String lastName, String email, String conDet, String qualDetails,
				String passYear, String otp, MultipartFile resumeFile) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.conDet = conDet;
			this.qualDetails = qualDetails;
			this.passYear = passYear;
			this.otp = otp;
			this.resumeFile = resumeFile;
		}

		public ApplicantDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public void setVerified(boolean b) {
			// TODO Auto-generated method stub
			
		}
		
		 public Applicant toEntity() {
		        Applicant applicant = new Applicant();
		        applicant.setFirstName(this.firstName);
		        applicant.setLastName(this.lastName);
		        applicant.setEmail(this.email);
		        applicant.setConDet(this.conDet);
		        applicant.setQualDetails(this.qualDetails);
		        applicant.setPassYear(this.passYear);
		        // Set other fields as needed
		        return applicant;
		    }
		
	    
	}






