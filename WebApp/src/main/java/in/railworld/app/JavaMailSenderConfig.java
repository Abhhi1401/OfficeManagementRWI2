package in.railworld.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import in.railworld.app.model.EmailConfig;
import in.railworld.app.util.EmailConfigService;

@Configuration
public class JavaMailSenderConfig {
	 
	
	@Autowired
	 private EmailConfigService emailConfigService;
      
	 
	@Bean
	public JavaMailSender getJavaMailSender() {
		 EmailConfig emailConfig = emailConfigService.getEmailConfiguration(1);
		  
	       JavaMailSenderImpl mailSender =	  new JavaMailSenderImpl();
//	       System.out.println(emailConfig);
	       mailSender.setHost(emailConfig.getHost());
	        mailSender.setPort(emailConfig.getPort());
	        mailSender.setUsername(emailConfig.getUsername());
	        mailSender.setPassword(emailConfig.getPassword());
		      
	           
	         return mailSender;
	}
}
