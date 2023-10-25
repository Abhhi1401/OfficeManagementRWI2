package in.railworld.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import in.railworld.app.controller.model.EmailRequest;
import in.railworld.app.model.EmailDetails;
import in.railworld.app.repository.EmailDetailsRepository;

@Service
public class EmailService {

    @Autowired
    private SendGrid sendGrid;


        @Autowired
        private EmailDetailsRepository emailDetailsRepository;

        public ResponseEntity<String> sendmail(Long id, List<String> toEmails, EmailRequest emailRequest) {
            String fromEmail = getEmailFromDatabase(id); // Fetch from email from the database based on the provided ID
            Email from = new Email(fromEmail);

            String subject = "Sendgrid email";
            Content content = new Content("text/plain", emailRequest.getBody());

            Request request = new Request();

            try {
                for (String toEmail : toEmails) {
                    Email to = new Email(toEmail);
                    Mail mail = new Mail(from, subject, to, content);

                    request.setMethod(Method.POST);
                    request.setEndpoint("mail/send");
                    request.setBody(mail.build());
                                
                    Response response = sendGrid.api(request);

                    System.out.println(response.getStatusCode());
                    System.out.println(response.getBody());
                    System.out.println(response.getHeaders());

                    // You can handle the response as needed, e.g., collect results, logging, etc.
                }

                // Return a summary response, you can customize this based on your needs
                return ResponseEntity.ok("Multiple emails sent successfully");
            } catch (IOException ex) {
                throw new RuntimeException("Error sending emails", ex);
            }
        }

        private String getEmailFromDatabase(Long id) {
            // Fetch the from email address from the database based on the provided ID
            EmailDetails emailDetails = emailDetailsRepository.findById(id).orElse(null);
            return emailDetails != null ? emailDetails.getFromEmail() : null;
        }
    }


