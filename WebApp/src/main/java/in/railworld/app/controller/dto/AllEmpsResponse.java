package in.railworld.app.controller.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
  public class AllEmpsResponse {
     
	   private String status;
	   
	   private String token;
	   
	   private String message;
	   
	   
	   private List<EmployeeResponse> emps;
	   
	   
	   
	   public AllEmpsResponse() {
		// TODO Auto-generated constructor stub
	}



	public AllEmpsResponse(String status, String token, String message, List<EmployeeResponse> emps) {
		super();
		this.status = status;
		this.token = token;
		this.message = message;
		this.emps = emps;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public List<EmployeeResponse> getEmps() {
		return emps;
	}



	public void setEmps(List<EmployeeResponse> emps) {
		this.emps = emps;
	}



	@Override
	public String toString() {
		return "AllEmpsResponse [status=" + status + ", token=" + token + ", message=" + message + ", emps=" + emps
				+ "]";
	}
	   
	   
	   
}
