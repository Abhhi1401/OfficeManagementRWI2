package in.railworld.app.model;

import java.sql.Date;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Entity
@Getter
@Setter
public class JobDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobId;
    
    @Column(length = 100000)
    private String jobDesc;

	private String jobTitle;
    private int noOfReq;
    private String jobQual; //jobType, domain, jobLastDate, location
    private String minExp;
    private String jobType;
    private String domain;
    private String jobLastDate;
    private String location;
  
	private String salRange;
    private Date jobPostedDate;
    private String skills;
    
    
    @Lob
    @Column(length = 1000000)
    private byte[] jobImage; // Byte array to store the image data
    private String jobImageLink;
    
    private String jobLink;

    
    
	public JobDetails() {
		super();
		// TODO Auto-generated constructor stub
	}



	public JobDetails(int jobId, String jobDesc, String jobTitle, int noOfReq, String jobQual, String minExp,
			String jobType, String domain, String jobLastDate, String location, String salRange, Date jobPostedDate,
			String skills, byte[] jobImage, String jobImageLink, String jobLink) {
		super();
		this.jobId = jobId;
		this.jobDesc = jobDesc;
		this.jobTitle = jobTitle;
		this.noOfReq = noOfReq;
		this.jobQual = jobQual;
		this.minExp = minExp;
		this.jobType = jobType;
		this.domain = domain;
		this.jobLastDate = jobLastDate;
		this.location = location;
		this.salRange = salRange;
		this.jobPostedDate = jobPostedDate;
		this.skills = skills;
		this.jobImage = jobImage;
		this.jobImageLink = jobImageLink;
		this.jobLink = jobLink;
	}



	public int getJobId() {
		return jobId;
	}



	public void setJobId(int jobId) {
		this.jobId = jobId;
	}



	public String getJobDesc() {
		return jobDesc;
	}



	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}



	public String getJobTitle() {
		return jobTitle;
	}



	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}



	public int getNoOfReq() {
		return noOfReq;
	}



	public void setNoOfReq(int noOfReq) {
		this.noOfReq = noOfReq;
	}



	public String getJobQual() {
		return jobQual;
	}



	public void setJobQual(String jobQual) {
		this.jobQual = jobQual;
	}



	public String getMinExp() {
		return minExp;
	}



	public void setMinExp(String minExp) {
		this.minExp = minExp;
	}



	public String getJobType() {
		return jobType;
	}



	public void setJobType(String jobType) {
		this.jobType = jobType;
	}



	public String getDomain() {
		return domain;
	}



	public void setDomain(String domain) {
		this.domain = domain;
	}



	public String getJobLastDate() {
		return jobLastDate;
	}



	public void setJobLastDate(String jobLastDate) {
		this.jobLastDate = jobLastDate;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getSalRange() {
		return salRange;
	}



	public void setSalRange(String salRange) {
		this.salRange = salRange;
	}



	public Date getJobPostedDate() {
		return jobPostedDate;
	}



	public void setJobPostedDate(Date jobPostedDate) {
		this.jobPostedDate = jobPostedDate;
	}



	public String getSkills() {
		return skills;
	}



	public void setSkills(String skills) {
		this.skills = skills;
	}



	public byte[] getJobImage() {
		return jobImage;
	}



	public void setJobImage(byte[] jobImage) {
		this.jobImage = jobImage;
	}



	public String getJobImageLink() {
		return jobImageLink;
	}



	public void setJobImageLink(String jobImageLink) {
		this.jobImageLink = jobImageLink;
	}



	public String getJobLink() {
		return jobLink;
	}



	public void setJobLink(String jobLink) {
		this.jobLink = jobLink;
	}



	@Override
	public String toString() {
		return "JobDetails [jobId=" + jobId + ", jobDesc=" + jobDesc + ", jobTitle=" + jobTitle + ", noOfReq=" + noOfReq
				+ ", jobQual=" + jobQual + ", minExp=" + minExp + ", jobType=" + jobType + ", domain=" + domain
				+ ", jobLastDate=" + jobLastDate + ", location=" + location + ", salRange=" + salRange
				+ ", jobPostedDate=" + jobPostedDate + ", skills=" + skills + ", jobImage=" + Arrays.toString(jobImage)
				+ ", jobImageLink=" + jobImageLink + ", jobLink=" + jobLink + "]";
	}

	
	
  
	
}

