package in.railworld.app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tId;
	private String teamName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "team_employee", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
	private List<Employee> employees = new ArrayList<>();

	
	@ManyToOne
	@JoinColumn(name = "proj_id")
	private Project project;

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employees, tId, teamName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return Objects.equals(employees, other.employees) && tId == other.tId
				&& Objects.equals(teamName, other.teamName);
	}

	@Override
	public String toString() {
		return "Team [tId=" + tId + ", teamName=" + teamName + ", employees=" + employees + "]";
	}

	public Team(int tId, String teamName, List<Employee> employees, Project project) {
		super();
		this.tId = tId;
		this.teamName = teamName;
		this.employees = employees;
		this.project = project;
	}

	public Team() {
		super();
	}
	
	

}
