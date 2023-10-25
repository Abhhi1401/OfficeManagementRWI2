package in.railworld.app.Services.Implemetation;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.railworld.app.model.Attendance;
import in.railworld.app.model.Employee;
import in.railworld.app.repository.AttendanceRepository;
import in.railworld.app.repository.EmployeeRepository;
import in.railworld.app.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
   

    @Override
	public String markAttendance(int employeeId, Attendance attendance) {
		Employee employee = employeeRepository.findById(employeeId).orElse(null);
      if (employee == null) {
          return "Employee with ID " + employeeId + " not found";
      }

      attendance.setEmployee(employee);
      attendance.setStatus(determineAttendanceStatus(attendance));
      attendanceRepository.save(attendance);

      return "Attendance marked successfully for Employee ID: " + employeeId;
  }	


        @Override
        public List<Attendance> getAttendanceListByEmployeeId(int employeeId) {
            return attendanceRepository.findByEmployeeId(employeeId);
        }

        private String determineAttendanceStatus(Attendance attendance) {
            LocalTime punchIn = attendance.getPunchIn();
            LocalTime punchOut = attendance.getPunchOut();

            if (punchIn == null || punchOut == null) {
                return "Absent"; // Either punch-in or punch-out is missing
            }

            // Determine if an employee is present based on punch-in and punch-out times
            if (punchOut.isAfter(punchIn)) {
                return "Present";
            } else {
                return "Absent";
            }
        }


		
    }

