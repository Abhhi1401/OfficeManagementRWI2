package in.railworld.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.railworld.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//	List<Employee> findByOfficeId();

	public Optional<Employee> findByEmail(String email);

	
	


	
	 
	 
}
