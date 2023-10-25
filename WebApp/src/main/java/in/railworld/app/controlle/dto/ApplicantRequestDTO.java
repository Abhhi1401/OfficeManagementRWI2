package in.railworld.app.controlle.dto;



	

	import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

	public class ApplicantRequestDTO {
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String conDet;
	    private String qualDetails;
	    private String passYear;
	    private String exp;
	    private Date dOB;
	    private byte[] resumeFile; // Represent the resume file as a byte array

	    // Constructors, getters, and setters

	    public ApplicantRequestDTO() {
	    }

	    public ApplicantRequestDTO(String firstName, String lastName, String email, String conDet, String qualDetails, String passYear, String exp, Date dOB, byte[] resumeFile) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	        this.conDet = conDet;
	        this.qualDetails = qualDetails;
	        this.passYear = passYear;
	        this.exp = exp;
	        this.dOB = dOB;
	        this.resumeFile = resumeFile;
	    }

	    // Getters and setters for the attributes

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

	    public String getExp() {
	        return exp;
	    }

	    public void setExp(String exp) {
	        this.exp = exp;
	    }

	    public Date getdOB() {
	        return dOB;
	    }

	    public void setdOB(Date dOB) {
	        this.dOB = dOB;
	    }

	    public byte[] getResumeFile() {
	        return resumeFile;
	    }

	    public void setResumeFile(byte[] resumeFile) {
	        this.resumeFile = resumeFile;
	    }
	}


