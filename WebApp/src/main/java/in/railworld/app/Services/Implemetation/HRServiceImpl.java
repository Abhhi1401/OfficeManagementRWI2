package in.railworld.app.Services.Implemetation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.railworld.app.controller.dto.EmployeeReqDto;
import in.railworld.app.model.Employee;
import in.railworld.app.model.HR;
import in.railworld.app.repository.EmployeeRepository;
import in.railworld.app.repository.HRRepository;
import in.railworld.app.service.HRService;
import in.railworld.app.util.EmailService;

@Service
public class HRServiceImpl implements HRService {
	@Autowired
	EmailService emailService;
	
	@Autowired
	private HRRepository hrRepo;
	
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public void deleteEmployeeById(int employeeId) {
        // Check if the employee exists before deleting
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
        } else {
            throw new IllegalArgumentException("Employee not found with ID: " + employeeId);
        }
    }


	@Override
	public HR HrRegister(HR hr) {
		
			
			return hrRepo.save(hr);
		}


	@Override
	public String addEmployee(EmployeeReqDto emp) {
		// TODO Auto-generated method stub
		    
		 
		   
		Employee emp1 =   empRepo.save(getEmployee(emp));
		
		if(emp1 != null) {
			 return "Employee is added";
		}
		
		return "Not added";
	}


	private Employee getEmployee(EmployeeReqDto emp) {
		// TODO Auto-generated method stub
		Employee emp1 = new Employee();
		   emp1.setName(emp.getName());
		   emp1.setEmail(emp.getEmail());
		   emp1.setContact(emp.getContact());
		   emp1.setDeg(emp.getDeg());
		   emp1.setRole(emp.getRole());
		   emp1.setAddresslist(emp.getAddresslist());
		   emp1.setSalary(emp.getSalary());
		   emp1.setPassword(emp.getPassword());
		  
		  return emp1;
		
	}
	
	
	


	
		
	

}
