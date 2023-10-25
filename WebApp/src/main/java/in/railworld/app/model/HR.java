package in.railworld.app.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class HR {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long hrid;
	private String email;
	
	@OneToOne
	@JoinColumn(name="id")
	private Employee Employee;

	public Long getHrid() {
		return hrid;
	}

	public void setHrid(Long hrid) {
		this.hrid = hrid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee getEmployee() {
		return Employee;
	}

	public void setEmployee(Employee employee) {
		this.Employee = employee;
	}
	

}

