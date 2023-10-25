package in.railworld.app.model;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "leaves")

public class LeaveRequest {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  Long id;
	private LocalDate StartDate;
	private LocalDate endDate;
	private String reason;
	
	private LeaveStatus status=LeaveStatus.PENDING;
	
	@Transient
	private MultipartFile attachement;
	
	@ManyToOne
	private Employee employee;

	
	
	public LeaveRequest() {
		super();
		// TODO Auto-generated constructor stub
	}



	public LeaveRequest(Long id, LocalDate startDate, LocalDate endDate, String reason, LeaveStatus status,
			MultipartFile attachement, Employee employee) {
		super();
		this.id = id;
		StartDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.status = status;
		this.attachement = attachement;
		this.employee = employee;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public LocalDate getStartDate() {
		return StartDate;
	}



	public void setStartDate(LocalDate startDate) {
		StartDate = startDate;
	}



	public LocalDate getEndDate() {
		return endDate;
	}



	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}



	public String getReason() {
		return reason;
	}



	public void setReason(String reason) {
		this.reason = reason;
	}



	public LeaveStatus getStatus() {
		return status;
	}



	public void setStatus(LeaveStatus status) {
		this.status = status;
	}



	public MultipartFile getAttachement() {
		return attachement;
	}



	public void setAttachement(MultipartFile attachement) {
		this.attachement = attachement;
	}



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	public enum LeaveStatus{
		PENDING ,APPROVED ,REJECTED
	}

	


}
