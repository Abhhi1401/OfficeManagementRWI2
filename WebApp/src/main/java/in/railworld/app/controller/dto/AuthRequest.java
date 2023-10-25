package in.railworld.app.controller.dto;

import org.springframework.stereotype.Component;

@Component
public class AuthRequest {
	
	
	public String name;
	public String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AuthRequest(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public AuthRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AuthRequest [name=" + name + ", password=" + password + "]";
	}
	

}
