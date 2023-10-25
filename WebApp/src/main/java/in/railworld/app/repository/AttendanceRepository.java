package in.railworld.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.railworld.app.model.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    List<Attendance> findByEmployeeId(int employeeId);

	



	

    // You can add custom query methods if needed
}

