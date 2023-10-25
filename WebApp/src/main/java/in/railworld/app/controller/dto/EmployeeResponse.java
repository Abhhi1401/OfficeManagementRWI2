package in.railworld.app.controller.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;


@Component
public class EmployeeResponse {
       
     private int id;
	
	private String name;
	
	private String email;
	
	
	private String contact;
	
	private Date hire_Date;
	
	
	private double salary;
	
	
	
	public EmployeeResponse() {
		// TODO Auto-generated constructor stub
	}



	public EmployeeResponse(int id, String name, String email, String contact, Date hire_Date, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.hire_Date = hire_Date;
		this.salary = salary;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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



	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	public Date getHire_Date() {
		return hire_Date;
	}



	public void setHire_Date(Date hire_Date) {
		this.hire_Date = hire_Date;
	}



	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}



	@Override
	public String toString() {
		return "EmployeeResponse [id=" + id + ", name=" + name + ", email=" + email + ", contact=" + contact
				+ ", hire_Date=" + hire_Date + ", salary=" + salary + "]";
	}
	
	
	
}
