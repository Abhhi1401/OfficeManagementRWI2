package in.railworld.app.Services.Implemetation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.railworld.app.controller.dto.EmployeeProjectDetailDTO;
import in.railworld.app.model.Employee;
import in.railworld.app.model.Project;
import in.railworld.app.repository.EmployeeRepository;
import in.railworld.app.repository.ProjectRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;
    
     @Autowired 
    private EmployeeProjectDetailDTO employeeProjectDetailDTO;
    
    
    @Autowired
    public ProjectService(ProjectRepository projectRepository, EmployeeRepository employeeRepository) {
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
    }

    public Project addProject(Project project) {
        // Your existing code to add a project
        return projectRepository.save(project);
    }

    public Optional<Project> getProjectById(int projectId) {
        return projectRepository.findById(projectId);
    }

    public Iterable<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project assignEmployeeToProject(int projectId, int employeeId) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        if (projectOptional.isPresent() && employeeOptional.isPresent()) {
            Project project = projectOptional.get();
            Employee employee = employeeOptional.get();

            // Associate the employee with the project
            project.getEmployees().add(employee);

            // Update the project in the database
            return projectRepository.save(project);
        } else {
            throw new IllegalArgumentException("Project or employee not found");
        }
    }

    public Project unassignEmployeeFromProject(int projectId, int employeeId) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);

        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();

            // Remove the employee from the project
            project.getEmployees().removeIf(employee -> employee.getId() == employeeId);

            // Update the project in the database
            return projectRepository.save(project);
        } else {
            throw new IllegalArgumentException("Project not found");
        }
    }
    
    @Autowired
    private EntityManager entityManager;

    public List<EmployeeProjectDetailDTO> getEmployeeProjectDetails() {
        String jpql = "SELECT new in.railworld.app.dto.EmployeeProjectDetailDTO(e.name, p.projId, t.teamId, p.startDate, p.endDate) " +
                      "FROM Employee e " +
                      "JOIN e.projects p " +
                      "JOIN p.teamlist t";

        TypedQuery<EmployeeProjectDetailDTO> query = entityManager.createQuery(jpql, EmployeeProjectDetailDTO.class);

        return query.getResultList();
    }
}
