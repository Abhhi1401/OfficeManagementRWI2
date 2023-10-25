package in.railworld.app.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import in.railworld.app.controller.dto.BulkEmailDto;

@Service
public class EmailServiceImpl implements EmailService {
	
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private EmailConfigService emailConfigService;
	
	//@Override
		//public void sendEmail(String to, String sub, String msg) {
			
			//SimpleMailMessage mailMessage =new SimpleMailMessage();
			//mailMessage.setTo(to);
			//mailMessage.setSubject(sub);
			//mailMessage.setText(msg);
			
			//javaMailSender.send(mailMessage);
			
		//}

	@Override
	public void SendBulkEmail(BulkEmailDto bulkemail) {
		
		
		// get id from which you want to send email  1
//		    JavaMailSender javaMailSender =    getJavaMailSender(1);
//		       System.out.println(javaMailSender);
		  // JavaMailSender
		     
		 
		SimpleMailMessage message=new SimpleMailMessage();
		
		message.setSubject(bulkemail.getSubject());
		message.setText(bulkemail.getContent());
		
	
		
		for(String recipient :bulkemail.getRecipients()){
			
			message.setTo(recipient);
			System.out.println(javaMailSender.toString());
			  javaMailSender.send(message);
			  
			  System.out.println(message);
		}
		
	}
	
	
	

	

}