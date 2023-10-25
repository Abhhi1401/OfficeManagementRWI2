package in.railworld.app.model;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Employee")
public class Employee {
      
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "Employee_name", nullable = false)
	private String name;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	private String contact;
	
	private Date hire_Date;
	
	
	private double salary;
	
	
	private String role;
	
	
	private String deg;
	
	
	private String photoLink;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Address> addresslist = new ArrayList<>();
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Attendance> attendanceList = new ArrayList<>();
	
   
    
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}



	public Employee(int id, String name, String email, String password, String contact, Date hire_Date, double salary,
			String role, String deg, String photoLink, List<Address> addresslist) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.hire_Date = hire_Date;
		this.salary = salary;
		this.role = role;
		this.deg = deg;
		this.photoLink = photoLink;
		this.addresslist = addresslist;
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



	public String getPhotoLink() {
		return photoLink;
	}



	public void setPhotoLink(String photoLink) {
		this.photoLink = photoLink;
	}



	public List<Address> getAddresslist() {
		return addresslist;
	}



	public void setAddresslist(List<Address> addresslist) {
		this.addresslist = addresslist;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", contact="
				+ contact + ", hire_Date=" + hire_Date + ", salary=" + salary + ", role=" + role + ", deg=" + deg
				+ ", photoLink=" + photoLink + ", addresslist=" + addresslist + "]";
	}



	public void setHireDate(Date hireDate) {
		// TODO Auto-generated method stub
		
	}



	
	
	

	
	
	
	
	
	

	
}
