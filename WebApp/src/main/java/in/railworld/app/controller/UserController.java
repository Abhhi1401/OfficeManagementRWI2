package in.railworld.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.railworld.app.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@PostMapping("/add")
//	public String addNewUser(@RequestBody UserInfo userInfo) {
//		return userService.addUser(userInfo);
//	}
}
