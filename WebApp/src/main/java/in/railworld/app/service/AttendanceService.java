package in.railworld.app.service;

import java.util.List;

import in.railworld.app.model.Attendance;

public interface AttendanceService {

    List<Attendance> getAttendanceListByEmployeeId(int employeeId);

	public String markAttendance(int employeeId, Attendance attendance);

    // Other methods for business logic...
}

