package in.railworld.app.controller.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class EmployeeProjectDetailDTO {
	

		private String employeeName;
	    private int projectId;
	    private int teamId;
	    private Date startDate;
	    private Date endDate;

	    public EmployeeProjectDetailDTO(String employeeName, int projectId, int teamId, Date startDate, Date endDate) {
	        this.employeeName = employeeName;
	        this.projectId = projectId;
	        this.teamId = teamId;
	        this.startDate = startDate;
	        this.endDate = endDate;
	    }

	    public String getEmployeeName() {
	        return employeeName;
	    }

	    public void setEmployeeName(String employeeName) {
	        this.employeeName = employeeName;
	    }

	    public int getProjectId() {
	        return projectId;
	    }

	    public EmployeeProjectDetailDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public void setProjectId(int projectId) {
	        this.projectId = projectId;
	    }

	    public int getTeamId() {
	        return teamId;
	    }

	    public void setTeamId(int teamId) {
	        this.teamId = teamId;
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
	}


  
