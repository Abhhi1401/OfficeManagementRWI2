package in.railworld.app.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.railworld.app.model.EmailConfig;
import in.railworld.app.repository.EmailConfigRepo;

@Service
public class EmailConfigServiceImpl  implements EmailConfigService{
      
	@Autowired
	private EmailConfigRepo emailConfigRepo;
	
	
	@Override
	public EmailConfig getEmailConfiguration(int id) {
		// TODO Auto-generated method stub
		Optional<EmailConfig> opt = emailConfigRepo.findById(id);
		if(opt.get() != null) {
			return opt.get();
		}
		return null;
	}


	@Override
	public String setEmailConfiguration(EmailConfig emailConfig) {
		// TODO Auto-generated method stub
		    EmailConfig emailconfig1 =   emailConfigRepo.save(emailConfig);
		    if(emailconfig1 != null) {
		    	return "sender email is saved with id : " +emailconfig1.getEmailConfigId();
		    }
		    return null;
	}

}