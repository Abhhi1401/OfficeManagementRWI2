package in.railworld.app.Services.Implemetation;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.swing.text.DateFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.railworld.app.controller.dto.LeaveRequestDto;
import in.railworld.app.model.LeaveRequest;
import in.railworld.app.model.LeaveRequest.LeaveStatus;
import in.railworld.app.repository.LeaveRepository;
import jakarta.persistence.EntityNotFoundException;
@Service
public class LeaveServiceImpl {
	@Autowired
	private  LeaveRepository leaverepo;
	
	public   LeaveRequest CreateLeaveRequest(LeaveRequestDto leaveRequestDto,MultipartFile attachement){
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LeaveRequest leave=new LeaveRequest();
			leave.setStartDate(LocalDate.parse(leaveRequestDto.getStartDate(), formatter));
			leave.setEndDate(LocalDate.parse(leaveRequestDto.getEndDate(), formatter));
			leave.setReason(leaveRequestDto.getReason());
			leave.setAttachement(leaveRequestDto.getAttachement());
			
			 
			String originalFileName = attachement.getOriginalFilename();
		        String attachFileName = "Attachement_" + originalFileName;
		        String attachPath = "D:/OMrwi/" + attachFileName;
			
			
			  // Save the uploaded resume file
           
            File destFile = new File(attachPath);
            destFile.createNewFile();
            attachement.transferTo(destFile);
            
            leaverepo.save(leaveRequestDto);
            return leave;
			
		}catch(Exception e) {
			
		}
		return null;
		
	}

//	public LeaveRequest applyForLeave(LeaveRequest leaveRequest) {
//		return leaverepo.save(leaveRequest);
//	}
	
	public List<LeaveRequest> getAllLeaveRequests() {
        // Retrieve all leave requests from the database
        return leaverepo.findAll();
    }

    public LeaveRequest getLeaveRequestById(Long id) {
        // Retrieve a leave request by its ID from the database
        Optional<LeaveRequest> leaveRequestOptional = leaverepo.findById(id);
        return leaveRequestOptional.orElse(null);
    }

    public LeaveRequest approveLeaveRequest(Long leaveRequestId) {
        LeaveRequest leaveRequest = leaverepo.findById(leaveRequestId)
                .orElseThrow(() -> new EntityNotFoundException("Leave request not found"));
        leaveRequest.setStatus(LeaveStatus.APPROVED);
        return leaverepo.save(leaveRequest);
    }

}
