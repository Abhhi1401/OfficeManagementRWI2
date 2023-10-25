package in.railworld.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.railworld.app.controller.dto.LeaveRequestDto;
import in.railworld.app.model.LeaveRequest;
import in.railworld.app.model.LeaveRequest.LeaveStatus;
@Repository
public interface LeaveRepository extends JpaRepository <LeaveRequest , Long> {
	void save(LeaveRequestDto leaveRequestDto);
	List<LeaveRequest> findByStatus(LeaveStatus status);

}
