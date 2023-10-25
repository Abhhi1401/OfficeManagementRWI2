package in.railworld.app.service;

import in.railworld.app.controller.dto.EmployeeReqDto;
import in.railworld.app.model.HR;

public interface HRService {

	HR HrRegister(HR hr);
	
	
	
	public String addEmployee(EmployeeReqDto emp);
	
	
	
}
