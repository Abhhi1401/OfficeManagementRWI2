package in.railworld.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.railworld.app.controller.model.EmailRequest;
import in.railworld.app.model.EmailDetails;
import in.railworld.app.repository.EmailDetailsRepository;
import in.railworld.app.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@Autowired
    private EmailDetailsRepository emailDetailsRepository;


	@PostMapping("/sendemails/{id}")
	public ResponseEntity<String> sendEmails(@PathVariable Long id, @RequestBody EmailRequest emailRequest) {
	    List<String> toEmails = emailRequest.getToEmails();

	    if (toEmails == null || toEmails.isEmpty()) {
	        return new ResponseEntity<>("No recipients provided", HttpStatus.BAD_REQUEST);
	    }

	    ResponseEntity<String> response = emailService.sendmail(id, toEmails, emailRequest);

	    if (response.getStatusCode() == HttpStatus.OK) {
	        return new ResponseEntity<>("Emails sent successfully", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Failed to send emails", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

    
    


@PostMapping("/save/from-email")
public ResponseEntity<EmailDetails> createEmailDetails(@RequestBody EmailDetails emailDetails) {
    EmailDetails createdEmailDetails = emailDetailsRepository.save(emailDetails);
    return new ResponseEntity<>(createdEmailDetails, HttpStatus.CREATED);
}
}
