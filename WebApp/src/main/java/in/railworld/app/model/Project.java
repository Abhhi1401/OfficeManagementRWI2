package in.railworld.app.model;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;



@Entity
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int projId;
    private String projName;
    private Date startDate;
    private Date endDate;
    private String status;
    private String repository;
    
    
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
	private List<Employee> employees = new ArrayList<>();

    
    
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private List<Team> teamlist = new ArrayList<>();
    
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Project(int projId, String projName, Date startDate, Date endDate, String status, String repository,
			List<Team> teamlist) {
		super();
		this.projId = projId;
		this.projName = projName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.repository = repository;
		this.teamlist = teamlist;
	}





	public int getProjId() {
		return projId;
	}



	public void setProjId(int projId) {
		this.projId = projId;
	}



	public String getProjName() {
		return projName;
	}



	public void setProjName(String projName) {
		this.projName = projName;
	}



	public Date getStartDate() {
		return startDate;
	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public Date getEndDate() {
		return endDate;
	}



	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getRepository() {
		return repository;
	}



	public void setRepository(String repository) {
		this.repository = repository;
	}



	public List<Team> getTeamlist() {
		return teamlist;
	}



	public void setTeamlist(List<Team> teamlist) {
		this.teamlist = teamlist;
	}

    
	
	

	public List<Employee> getEmployees() {
		return employees;
	}



	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}



	@Override
	public String toString() {
		return "Project [projId=" + projId + ", projName=" + projName + ", startDate=" + startDate + ", endDate="
				+ endDate + ", status=" + status + ", repository=" + repository + ", teamlist=" + teamlist + "]";
	}



	
	

	
    

	
	
	   

}
