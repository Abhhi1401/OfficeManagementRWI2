package in.railworld.app.Services.Implemetation;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.railworld.app.model.JobDetails;
import in.railworld.app.repository.JobDetailsRepository;
import in.railworld.app.service.JobDetailsService;

@Service
public class JobDetailsServiceImpl implements JobDetailsService {

    @Autowired
    private JobDetailsRepository jobDetailsRepository;

  
    	

//    @Override
//    public JobDetails updateJob(int jobId, JobDetails jobDetails) {
//        JobDetails existingJob = getJobById(jobId);
//        if (existingJob != null) {
//            existingJob.setJobTitle(jobDetails.getJobTitle());
//            existingJob.setJobDescription(jobDetails.getJobDescription());
//            existingJob.setJobQualification(jobDetails.getJobQualification());
//            return jobDetailsRepository.save(existingJob);
//        }
//        return null; // Job not found
//    }

    @Override
    public void deleteJob(int jobId) {
        jobDetailsRepository.deleteById(jobId);
    }

    @Override
    public JobDetails getJobById(int jobId) {
        return jobDetailsRepository.findById(jobId).orElse(null);
    } 

    @Override
    public List<JobDetails> getAllJobs() {
        return jobDetailsRepository.findAll();
    }

	@Override
	public JobDetails createJob(JobDetails jobDetails) {
	    return jobDetailsRepository.save(jobDetails);
	  }


	    @Override
	    public JobDetails createAndUploadJob(JobDetails job, MultipartFile imageFile) {
	        try {
	            JobDetails createdJob = jobDetailsRepository.save(job);

	            if (imageFile != null && !imageFile.isEmpty()) {
	                // Check if the uploaded file is a JPEG or PNG image
	                String originalFileName = imageFile.getOriginalFilename();
	                if (originalFileName != null && 
	                    (originalFileName.toLowerCase().endsWith(".jpg") ||
	                     originalFileName.toLowerCase().endsWith(".jpeg") ||
	                     originalFileName.toLowerCase().endsWith(".png"))) {

	                    String imageFileName = "job_" + originalFileName;
	                    String imagePath = "D:/OMrwi/OfficeManagementRWI/WebApp/src/main/resources/Static/" + imageFileName;
	                    File destFile = new File(imagePath);
	                    destFile.createNewFile();
	                    imageFile.transferTo(destFile);
	                    job.setJobLink("http://localhost:8080/jobs/html/" + job.getJobId());

	                    
	                    createdJob.setJobImageLink(imageFileName);
	                    jobDetailsRepository.save(createdJob);
	                }
	            }

	            return createdJob;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null; // Return null to indicate failure
	        }
	    }
	    


	
}
	




