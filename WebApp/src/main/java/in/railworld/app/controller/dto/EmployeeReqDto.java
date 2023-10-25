package in.railworld.app.controller.dto;

import java.util.ArrayList;
import java.util.List;

import in.railworld.app.model.Address;

public class EmployeeReqDto {
       
	
	
	
	
	private String name;
	
	
	private String email;
	
	private String password;
	
	private String contact;
	
	
	
	private double salary;
	
	
	private String role;
	
	
	private String deg;
	
	
	private List<Address> addresslist = new ArrayList<>();
	
	
	
	public EmployeeReqDto() {
		// TODO Auto-generated constructor stub
	}



	public EmployeeReqDto(String name, String email, String password, String contact, double salary, String role,
			String deg, List<Address> addresslist) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.salary = salary;
		this.role = role;
		this.deg = deg;
		this.addresslist = addresslist;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getDeg() {
		return deg;
	}



	public void setDeg(String deg) {
		this.deg = deg;
	}



	public List<Address> getAddresslist() {
		return addresslist;
	}



	public void setAddresslist(List<Address> addresslist) {
		this.addresslist = addresslist;
	}



	@Override
	public String toString() {
		return "EmployeeReqDto [name=" + name + ", email=" + email + ", password=" + password + ", contact=" + contact
				+ ", salary=" + salary + ", role=" + role + ", deg=" + deg + ", addresslist=" + addresslist + "]";
	}
	
	
	
	
	
	
}
