package in.railworld.app.controller.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class EmployeeDto {
    
    private int id;
    private String name;
    private String password;
    private String email;
    private double salary;
    private Date hireDate;
    private MultipartFile photo; // New attribute

    // No-args constructor
    public EmployeeDto() {
    }

	public EmployeeDto(int id, String name, String password, String email, double salary, Date hireDate,
			MultipartFile photo) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.salary = salary;
		this.hireDate = hireDate;
		this.photo = photo;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", salary="
				+ salary + ", hireDate=" + hireDate + ", photo=" + photo + "]";
	}

  
}
