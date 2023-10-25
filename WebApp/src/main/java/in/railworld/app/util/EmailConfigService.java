package in.railworld.app.util;

import in.railworld.app.model.EmailConfig;

public interface EmailConfigService {
    
	   public EmailConfig getEmailConfiguration(int id);
	   
	   public String setEmailConfiguration(EmailConfig emailConfig);
}

