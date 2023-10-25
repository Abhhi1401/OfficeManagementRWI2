package in.railworld.app.repository;


	
	import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.railworld.app.model.EmailConfig;


	@Repository
	public interface EmailConfigRepo extends JpaRepository<EmailConfig, Integer>{
	        
	}

