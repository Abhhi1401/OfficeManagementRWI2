package in.railworld.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.railworld.app.model.UserInfo;
import in.railworld.app.repository.UserInfoRepository;
@Service
public class UserService {
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	
	private PasswordEncoder passwordEncoder;
	
	public String addUser1(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		userInfoRepository.save(userInfo);
		return "User added to system";	
	}
	
	

    public void addUser(UserInfo userInfo) {
        // Here, you can perform any necessary validation or business logic
        // before saving the user to the database.
        userInfoRepository.save(userInfo);
    }
}
