package in.railworld.app.controller.dto;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class LeaveRequestDto{
	
	
	public String StartDate;
	public String endDate;
	public String reason;
	private Long employeeId;
	
	
	public LeaveRequestDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public LeaveRequestDto(String startDate, String endDate, String reason, Long employeeId) {
		super();
		StartDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.employeeId = employeeId;
	}


	public String getStartDate() {
		return StartDate;
	}


	public void setStartDate(String startDate) {
		StartDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public Long getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}


	@Override
	public String toString() {
		return "LeaveRequestDto [StartDate=" + StartDate + ", endDate=" + endDate + ", reason=" + reason
				+ ", employeeId=" + employeeId + "]";
	}


	public MultipartFile getAttachement() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
}
