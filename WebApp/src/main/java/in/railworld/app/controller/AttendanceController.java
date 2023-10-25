package in.railworld.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.railworld.app.model.Attendance;
import in.railworld.app.model.Employee;
import in.railworld.app.repository.EmployeeRepository;
import in.railworld.app.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
//    @PostMapping("/mark/{employeeId}")
//    public ResponseEntity<String> markAttendance(@PathVariable int employeeId, @RequestBody Attendance attendance) {
//        Employee employee = employeeRepository.findById(employeeId).orElse(null);
//        if (employee == null) {
//            return ResponseEntity.badRequest().body("Employee with ID " + employeeId + " not found");
//        }
//
//        String result = attendanceService.markAttendance(employeeId, attendance);
//        return ResponseEntity.ok(result);
//    }

    
    @PostMapping("/mark/{employeeId}")
    public ResponseEntity<String> markAttendance(@PathVariable int employeeId, @RequestBody Attendance attendance) {
        if (attendance == null) {
            return ResponseEntity.badRequest().body("Attendance data is missing");
        }

        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee == null) {
            return ResponseEntity.badRequest().body("Employee with ID " + employeeId + " not found");
        }

        String result = attendanceService.markAttendance(employeeId, attendance);
        return ResponseEntity.ok(result);
    }
    
    
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Attendance>> getAttendanceListByEmployeeId(@PathVariable int employeeId) {
        List<Attendance> attendanceList = attendanceService.getAttendanceListByEmployeeId(employeeId);
        return ResponseEntity.ok(attendanceList);
    }
   
}

