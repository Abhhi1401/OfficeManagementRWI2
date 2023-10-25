package in.railworld.app.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import in.railworld.app.controller.dto.EmployeeDto;
import in.railworld.app.controller.dto.EmployeeResponse;
import in.railworld.app.model.Address;
import in.railworld.app.model.Employee;
import in.railworld.app.repository.AddressRepository;
import in.railworld.app.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	public Employee findById(Integer employeeId) {
		Employee emp = employeeRepository.findById(employeeId).get();
		return emp;
	}
	
//	public List<Employee> findByRole(String role){
//		
//		List<Employee> emp = employeeRepository.findByRole(role);
//		return emp;
//	}
	
	public Optional<Employee> findByEmail(String email) {
		
		return employeeRepository.findByEmail(email);
	}
	
	public Employee employeeRegister(Employee employee) {
		
		return employeeRepository.save(employee);
	}
	
	
	public Employee updateEmployeeDetails(Employee employee, Integer employeeId) {
		Employee emp = employeeRepository.findById(employeeId).get();
		emp.setName(employee.getName());
		emp.setEmail(employee.getEmail());
		emp.setPassword(employee.getPassword());
		emp.setSalary(employee.getSalary());
		emp.setContact(employee.getContact());
		emp.setRole(employee.getRole());
		return employeeRepository.save(emp);
	}
	
	public List<EmployeeResponse> getAllEmployee(){
		
		List<Employee> employees = employeeRepository.findAll();
		
		return getListEmpsResponse(employees);
		
	}
	
	
	public List<EmployeeResponse>  getListEmpsResponse(List<Employee> emps){
		return   emps.stream()
		    .map(s -> {
		    	    
		    	return new EmployeeResponse(s.getId(), s.getName(), s.getEmail(), s.getContact(), s.getHire_Date(), s.getSalary());
		    }).collect(Collectors.toList());
		  
	}
	
//	public List<Employee> findBySalary(double salary){
//		
//		List<Employee> emp = employeeRepository.findBySalary(salary);
//		return emp;
//	}
	
	public void deleteEmployeeById(int employeeId) {
        // Check if the employee exists before deleting
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
        } else {
            throw new IllegalArgumentException("Employee not found with ID: " + employeeId);
        }
    }
	

	    public String createAddressForEmployee(int employeeId, Address addressDetails) {
	        Employee employee = employeeRepository.findById( employeeId).orElse(null);
	        if (employee == null) {
	            return "Employee not found";
	        }

	        Address newAddress = new Address();
	        newAddress.setStreet(addressDetails.getStreet());
	        newAddress.setCity(addressDetails.getCity());
	        newAddress.setState(addressDetails.getState());
	        newAddress.setPinCode(addressDetails.getPinCode());
	        newAddress.setEmployee(employee);

	        employee.getAddresslist().add(newAddress);
	        employeeRepository.save(employee);

	        return "Address added successfully for Employee ID: " + employeeId;
	    }
	
	
	 

	    public void deleteAddressByEmployeeId(int employeeId, int addressId) {
	        Employee employee = employeeRepository.findById(employeeId).orElse(null);
	        if (employee != null) {
	            List<Address> addressList = employee.getAddresslist();
	            addressList.removeIf(address -> address.getaId() == (addressId));
	                 
	            employeeRepository.save(employee);
	        } else {
	            throw new EntityNotFoundException("Employee with ID: " + employeeId + " not found.");
	        }
	}


		public Employee getEmployeeById(Long employeeId) {
			// TODO Auto-generated method stub
			return null;
		}

	    
	    
	    
	    public String addEmployee(EmployeeDto employeeDto, MultipartFile photo) throws IOException {
	        // Check if the uploaded file is a JPEG or PNG image
	        String imageLink = null;
	        if (photo != null && !photo.isEmpty()) {
	            String originalFileName = StringUtils.cleanPath(photo.getOriginalFilename());
	            if (originalFileName.toLowerCase().endsWith(".jpg") ||
	                originalFileName.toLowerCase().endsWith(".jpeg") ||
	                originalFileName.toLowerCase().endsWith(".png")) {

	                String imageFileName = "employee_" + System.currentTimeMillis() + "_" + originalFileName;
	                String imagePath = "D:/OMrwi/OfficeManagementRWI/WebApp/src/main/resources/Static/images/" + imageFileName;
	                File destFile = new File(imagePath);
	                destFile.getParentFile().mkdirs(); // Create directories if they don't exist

	                photo.transferTo(destFile);

	                // Set the image link
	                imageLink = "/images/" + imageFileName;
	            }
	        }

	        // Create an Employee entity (assuming you have an Employee entity)
	        Employee employee = new Employee();
	        employee.setId(employeeDto.getId());
	        employee.setName(employeeDto.getName());
	        employee.setPassword(employeeDto.getPassword());
	        employee.setEmail(employeeDto.getEmail());
	        employee.setSalary(employeeDto.getSalary());
	        employee.setHireDate(employeeDto.getHireDate());

	        // Set the image link in the Employee entity if available
	        if (imageLink != null) {
	            employee.setPhotoLink(imageLink);
	        }

	        // Save the employee entity to the database
	        employeeRepository.save(employee);

	        return "Employee added successfully!";
	    }    
	    
	    public String updateEmployee(int employeeId, EmployeeDto updatedEmployeeDto, MultipartFile updatedPhoto) throws IOException {
	        // Check if the employee with the given ID exists
	        Optional<Employee> existingEmployee = employeeRepository.findById(employeeId);
	        if (!existingEmployee.isPresent()) {
	            return "Employee not found";
	        }

	        Employee employee = existingEmployee.get();

	        // Update employee information
	        employee.setName(updatedEmployeeDto.getName());
	        employee.setEmail(updatedEmployeeDto.getEmail());
	        employee.setSalary(updatedEmployeeDto.getSalary());
	        employee.setHireDate(updatedEmployeeDto.getHireDate());

	        // Check if a new photo was provided for update
	        if (updatedPhoto != null && !updatedPhoto.isEmpty()) {
	            // Check if the uploaded file is a JPEG or PNG image
	            String originalFileName = StringUtils.cleanPath(updatedPhoto.getOriginalFilename());
	            if (originalFileName.toLowerCase().endsWith(".jpg") ||
	                originalFileName.toLowerCase().endsWith(".jpeg") ||
	                originalFileName.toLowerCase().endsWith(".png")) {

	                String imageFileName = "employee_" + System.currentTimeMillis() + "_" + originalFileName;
	                String imagePath = "D:/OMrwi/OfficeManagementRWI/WebApp/src/main/resources/Static/images/" + imageFileName;
	                File destFile = new File(imagePath);
	                destFile.getParentFile().mkdirs(); // Create directories if they don't exist

	                updatedPhoto.transferTo(destFile);

	                // Set the new image link
	                String newImageLink = "/images/" + imageFileName;
	                employee.setPhotoLink(newImageLink);
	            }
	        }

	        // Save the updated employee entity to the database
	        employeeRepository.save(employee);

	        return "Employee updated successfully!";
	    }
	  


}
