package in.railworld.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.railworld.app.Services.Implemetation.CookieService;
import in.railworld.app.model.JobDetails;
import in.railworld.app.service.JobDetailsService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobDetailsService jobDetailsService;
    
    @Autowired
    private CookieService cookieService;

    @PostMapping("/adddetails")
   public ResponseEntity<JobDetails> createJob(@RequestBody JobDetails jobDetails) {
        JobDetails createdJob = jobDetailsService.createJob(jobDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJob);
    }

//    @PutMapping("/{jobId}")
//    public ResponseEntity<JobDetails> updateJob(@PathVariable int jobId, @RequestBody JobDetails jobDetails) {
//        JobDetails updatedJob = jobDetailsService.updateJob(jobId, jobDetails);
//        if (updatedJob != null) {
//            return ResponseEntity.ok(updatedJob);
//        }
//       return ResponseEntity.notFound().build();
//   }

    @DeleteMapping("/delete/{jobId}")
    public ResponseEntity<Void> deleteJob(@PathVariable int jobId) {
        jobDetailsService.deleteJob(jobId);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping("/{jobId}")
//    public ResponseEntity<JobDetails> getJobById(@PathVariable int jobId) {
//        JobDetails job = jobDetailsService.getJobById(jobId);
//        if (job != null) {
//            return ResponseEntity.ok(job);
//        }
//        return ResponseEntity.notFound().build();
//    }
    
    
    @GetMapping("/{jobId}")
    public ResponseEntity<JobDetails> getJobById(@PathVariable int jobId, HttpServletResponse response) {
        JobDetails job = jobDetailsService.getJobById(jobId);
        if (job != null) {
            // Store the selected job ID in a permanent cookie
            cookieService.setPermanentCookie(response, "selectedJobId", String.valueOf(jobId));

            return ResponseEntity.ok(job);
        }
        return ResponseEntity.notFound().build();
    }
    
    

    @GetMapping("/list")
    public ResponseEntity<List<JobDetails>> getAllJobs() {
        List<JobDetails> jobs = jobDetailsService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }
    
  

        
        @Autowired
        private ObjectMapper objectMapper;

        @PostMapping("/create")
        @PreAuthorize("hasAuthority('ROLE_ADMIN')")
        public ResponseEntity<String> createAndUploadJob(
                @RequestParam(name = "jobDetails") String jobDetailsJson,
                @RequestParam(name = "imageFile", required = false) MultipartFile imageFile) {

            try {
                JobDetails jobDetails = objectMapper.readValue(jobDetailsJson, JobDetails.class);
                JobDetails createdJob = jobDetailsService.createAndUploadJob(jobDetails, imageFile);

                if (createdJob != null) {
                    return ResponseEntity.status(HttpStatus.CREATED).body("Job created");
                } else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create job");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error processing request");
            }
            
            
        }
        
    }


