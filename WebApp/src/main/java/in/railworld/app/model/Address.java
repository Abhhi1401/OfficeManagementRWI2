package in.railworld.app.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Address")
public class Address {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aId;
	private String street;
	private String city;
	private String state;
	private int pinCode;
	
	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee employee;
	
	@Override
	public int hashCode() {
		return Objects.hash(aId, city, employee, pinCode, state, street);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return aId == other.aId && Objects.equals(city, other.city) && Objects.equals(employee, other.employee)
				&& pinCode == other.pinCode && Objects.equals(state, other.state)
				&& Objects.equals(street, other.street);
	}
	public Address() {
		super();
	}
	@Override
	public String toString() {
		return "Address [aId=" + aId + ", street=" + street + ", city=" + city + ", state=" + state + ", pinCode="
				+ pinCode + ", employee=" + employee + "]";
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public Address(int aId, String street, String city, String state, int pinCode, Employee employee) {
		super();
		this.aId = aId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.employee = employee;
	}

	
	

}
