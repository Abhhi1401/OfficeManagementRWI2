package in.railworld.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.railworld.app.model.Employee;
import in.railworld.app.repository.EmployeeRepository;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Employee emp = empRepo.findByEmail(email)
		.orElseThrow(()-> new UsernameNotFoundException("Usernot found"+ email));
		return new UserInfoUserDetails(emp);
		
	}

}
