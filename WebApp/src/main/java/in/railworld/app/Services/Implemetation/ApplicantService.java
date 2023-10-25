package in.railworld.app.Services.Implemetation;
import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import in.railworld.app.model.Applicant;
import in.railworld.app.repository.ApplicantRepository;
@Service
public class ApplicantService {
    @Autowired
    private ApplicantRepository applicantrepository;
     @Autowired
     private SendGrid sendGrid; // Inject SendGrid
//    public Applicant createApplicant(Applicant applicant) {
//        String otp = generateRandomOtp();
//        applicant.setOtp(otp);
//        applicant.setVerified(false);
//        sendOtpByEmail(applicant.getEmail(), otp);
//        return applicantrepository.save(applicant);
//    }
    private void sendOtpByEmail(String email, String otp) {
    	
    	if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email address is required to send OTP.");
        }
        Email from = new Email("railworldIndiapvtLtd@gmail.com"); // Replace with your sender email
        Email to = new Email(email);
        String subject = "OTP Verification";
        Content content = new Content("text/plain", "Your OTP: " + otp);
        Mail mail = new Mail(from, subject, to, content);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (Exception ex) {
            throw new RuntimeException("Error sending OTP email", ex);
        }
    }
    private String generateRandomOtp() {
        return String.format("%06d", new Random().nextInt(999999));
    }
    public boolean verifyOtp(String email, String otp) {
        Optional<Applicant> optionalApplicant = applicantrepository.findByEmail(email);
        if (optionalApplicant.isPresent()) {
            Applicant applicant = optionalApplicant.get();
            if (applicant.getOtp().equals(otp)) {
                applicant.setVerified(true);
                applicant.setAppliStatus("verified");
                applicantrepository.save(applicant);
                return true;
            }
        }
        return false;
    }
//    public boolean uploadResume(Long applicantId, MultipartFile resumeFile) {
//        try {
//            Applicant applicant = applicantrepository.findById(applicantId).orElse(null);
//            if (applicant == null) {
//                return false; // Applicant not found
//            }
//
//
//            System.out.println(resumeFile.getName() + " " + resumeFile.getOriginalFilename());
//
//            // Check if the uploaded file is a PDF
//            String originalFileName = resumeFile.getOriginalFilename();
//            if (!originalFileName.toLowerCase().endsWith(".pdf")) {
//                return false; // Reject files that are not PDFs
//            }
//
//            // Save resume file to static folder
//            String resumeFileName = "resume_" + originalFileName; // Customize the filename as needed
//            String resumePath = "D:/Omrwi2/OfficeManagementRWI/WebApp/src/main/resources/Static/" + resumeFileName; // Update the path accordingly
//            File destFile = new File(resumePath);
//            destFile.createNewFile();
//            resumeFile.transferTo(destFile);
//
//            // Update job details object with resume link
//            applicant.setResumeLink(resumeFileName); // Assuming there's a field for resume link in the JobDetails class
//            applicantrepository.save(applicant);
//
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
    //Delete Applicant by id
    public boolean deleteApplicantById(Long applicantId) {
        try {
            Optional<Applicant> optionalApplicant = applicantrepository.findById(applicantId);
            if (optionalApplicant.isPresent()) {
                Applicant applicant = optionalApplicant.get();
                applicantrepository.delete(applicant);
                return true;
            } else {
                return false; // Applicant not found
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public ResponseEntity<String> createApplicantAndUploadResume(Applicant applicant, MultipartFile resumeFile) {
        try {
            // Generate a new OTP
            String otp = generateRandomOtp();
            // Set OTP and initial timestamp for the applicant
            applicant.setOtp(otp);
            applicant.setOtpTimestamp(LocalDateTime.now());
            applicant.setVerified(false);
            // Send the OTP to the user's email
            sendOtpByEmail(applicant.getEmail(), otp);
            // Check if the uploaded file is a PDF
            String originalFileName = resumeFile.getOriginalFilename();
            if (!originalFileName.toLowerCase().endsWith(".pdf")) {
                return ResponseEntity.badRequest().body("Resume must be in PDF format");
            }
            // Save the applicant details
            Applicant createdApplicant = applicantrepository.save(applicant);
            // Save the uploaded resume file
            String resumeFileName = "resume_" + originalFileName;
            String resumePath = "D:/OMrwi/OfficeManagementRWI/WebApp/src/main/resources/Static/" + resumeFileName;
            File destFile = new File(resumePath);
            destFile.createNewFile();
            resumeFile.transferTo(destFile);
            // Update the applicant with the resume link
            createdApplicant.setResumeLink(resumeFileName);
            applicantrepository.save(createdApplicant);
            return ResponseEntity.ok("Applicant created, OTP sent, and resume uploaded successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }

    }

     
    

    
    
    public ResponseEntity<String> createApplicantAndUploadResume1(Applicant applicant, MultipartFile resumeFile) {
        try {
            // Generate a new OTP
            String otp = generateRandomOtp();

            // Set OTP and initial timestamp for the applicant
            applicant.setOtp(otp);
            applicant.setOtpTimestamp(LocalDateTime.now());
            applicant.setVerified(false);

            // Send the OTP to the user's email
            sendOtpByEmail(applicant.getEmail(), otp);

            // Check if the uploaded file is a PDF
            String originalFileName = resumeFile.getOriginalFilename();
            if (!originalFileName.toLowerCase().endsWith(".pdf")) {
                return ResponseEntity.badRequest().body("Resume must be in PDF format");
            }

            // Save the applicant details
            Applicant createdApplicant = applicantrepository.save(applicant);

            // Save the uploaded resume file
            String resumeFileName = "resume_" + originalFileName;
            String resumePath = "D:/OMrwi/OfficeManagementRWI/WebApp/src/main/resources/Static/" + resumeFileName;
            File destFile = new File(resumePath);
            destFile.createNewFile();
            resumeFile.transferTo(destFile);
            
            // Update the applicant with the resume link
            createdApplicant.setResumeLink(resumeFileName);
            applicantrepository.save(createdApplicant);

            return ResponseEntity.ok("Applicant created, OTP sent, and resume uploaded successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }


    

   public void updateOtpAndTimestamp(String email, String newOtp, LocalDateTime newTimestamp) {
        Optional<Applicant> optionalApplicant = applicantrepository.findByEmail(email);
        if (optionalApplicant.isPresent()) {
             Applicant applicant = optionalApplicant.get();
            applicant.setOtp(newOtp);
            applicant.setOtpTimestamp(newTimestamp);
            applicantrepository.save(applicant);
        }
    }
    public void resendOtp(String email) {
        Optional<Applicant> optionalApplicant = applicantrepository.findByEmail(email);
        if (optionalApplicant.isPresent()) {
            Applicant applicant = optionalApplicant.get();
            LocalDateTime otpTimestamp = applicant.getOtpTimestamp();
            if (otpTimestamp != null) {
                LocalDateTime currentTime = LocalDateTime.now();
                Duration duration = Duration.between(otpTimestamp, currentTime);
                long minutesPassed = duration.toMinutes();
                // If the time interval for resending OTP has passed, generate and send a new OTP
                if (minutesPassed >= 5) {
                    String newOtp = generateRandomOtp();
                    applicant.setOtp(newOtp);
                    applicant.setOtpTimestamp(LocalDateTime.now());
                    applicant.setVerified(false);
                    applicantrepository.save(applicant);
                    sendOtpByEmail(email, newOtp);
                } else {
                    throw new RuntimeException("Please wait before resending OTP");
                }
            }
        } else {
            throw new RuntimeException("Applicant not found");
        }
    }


    









    

    public List<Applicant> getAllApplicants() {
        List<Applicant> applicants = applicantrepository.findAll();
        return applicants;
    }
   
}

