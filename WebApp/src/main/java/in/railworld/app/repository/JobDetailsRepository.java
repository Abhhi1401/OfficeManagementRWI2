package in.railworld.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.railworld.app.model.JobDetails;

@Repository
public interface JobDetailsRepository extends JpaRepository<JobDetails, Integer> {

	
	
}
