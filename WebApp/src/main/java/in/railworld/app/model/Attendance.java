package in.railworld.app.model;

import java.sql.Date;
import java.time.LocalTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attid; // Auto-generated ID for Attendance record

    private Date date;
    private LocalTime punchIn;
    private LocalTime punchOut;
   
    private String status; // "Present" or "Absent"

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
 
	public int getAttid() {
		return attid;
	}

	public void setAttid(int attid) {
		this.attid = attid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LocalTime getPunchIn() {
		return punchIn;
	}

	public void setPunchIn(LocalTime punchIn) {
		this.punchIn = punchIn;
	}

	public LocalTime getPunchOut() {
		return punchOut;
	}

	public void setPunchOut(LocalTime punchOut) {
		this.punchOut = punchOut;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Attendance(int attid, Date date, LocalTime punchIn, LocalTime punchOut,
			String status, Employee employee) {
		super();
		this.attid = attid;
		this.date = date;
		this.punchIn = punchIn;
		this.punchOut = punchOut;
		
		this.status = status;
		this.employee = employee;
	}

	public Attendance() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(attid, date, employee, punchIn, punchOut, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attendance other = (Attendance) obj;
		return attid == other.attid && Objects.equals(date, other.date) && Objects.equals(employee, other.employee)
				&& Objects.equals(punchIn, other.punchIn) && Objects.equals(punchOut, other.punchOut)
				&& Objects.equals(status, other.status);
	}

	

	

    
}
