package in.railworld.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import in.railworld.app.model.JobDetails;

public interface JobDetailsService {

   JobDetails createJob(JobDetails jobDetails);

//    JobDetails updateJob(int jobId, JobDetails jobDetails);

    void deleteJob(int jobId);

    JobDetails getJobById(int jobId);

    List<JobDetails> getAllJobs();
    
    
    
    JobDetails createAndUploadJob(JobDetails job, MultipartFile imageFile);

	 


	
}
