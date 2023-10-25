package in.railworld.app.model;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
@Entity
public class Applicant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long appid;
    private String firstName;
    private String lastName;
    private String email;
    private String conDet;
    private String qualDetails;
    private boolean verified;
    private String otp;
    private String appliStatus;
    private String passYear;
    private String exp;
    private String address;
    private LocalDateTime otpTimestamp;
    
    @Column(length = 10485760) 
    @Transient
    private MultipartFile uploadResume; // Store PDF content as byte array
    private String resumeLink;     
    private Date dOB; // Add date of birth attribute
    
    
	public Applicant() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getAppid() {
		return appid;
	}


	public void setAppid(Long appid) {
		this.appid = appid;
	}


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


	public boolean isVerified() {
		return verified;
	}


	public void setVerified(boolean verified) {
		this.verified = verified;
	}


	public String getOtp() {
		return otp;
	}


	public void setOtp(String otp) {
		this.otp = otp;
	}


	public String getAppliStatus() {
		return appliStatus;
	}


	public void setAppliStatus(String appliStatus) {
		this.appliStatus = appliStatus;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public LocalDateTime getOtpTimestamp() {
		return otpTimestamp;
	}


	public void setOtpTimestamp(LocalDateTime otpTimestamp) {
		this.otpTimestamp = otpTimestamp;
	}


	public MultipartFile getUploadResume() {
		return uploadResume;
	}


	public void setUploadResume(MultipartFile uploadResume) {
		this.uploadResume = uploadResume;
	}


	public String getResumeLink() {
		return resumeLink;
	}


	public void setResumeLink(String resumeLink) {
		this.resumeLink = resumeLink;
	}


	public Date getdOB() {
		return dOB;
	}


	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}


	@Override
	public String toString() {
		return "Applicant [appid=" + appid + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", conDet=" + conDet + ", qualDetails=" + qualDetails + ", verified=" + verified + ", otp=" + otp
				+ ", appliStatus=" + appliStatus + ", passYear=" + passYear + ", exp=" + exp + ", address=" + address
				+ ", otpTimestamp=" + otpTimestamp + ", uploadResume=" + uploadResume + ", resumeLink=" + resumeLink
				+ ", dOB=" + dOB + "]";
	}


	public Applicant(Long appid, String firstName, String lastName, String email, String conDet, String qualDetails,
			boolean verified, String otp, String appliStatus, String passYear, String exp, String address,
			LocalDateTime otpTimestamp, MultipartFile uploadResume, String resumeLink, Date dOB) {
		super();
		this.appid = appid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.conDet = conDet;
		this.qualDetails = qualDetails;
		this.verified = verified;
		this.otp = otp;
		this.appliStatus = appliStatus;
		this.passYear = passYear;
		this.exp = exp;
		this.address = address;
		this.otpTimestamp = otpTimestamp;
		this.uploadResume = uploadResume;
		this.resumeLink = resumeLink;
		this.dOB = dOB;
	}
	
}
