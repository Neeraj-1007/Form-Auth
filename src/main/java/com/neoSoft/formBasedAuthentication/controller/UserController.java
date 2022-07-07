package com.neoSoft.formBasedAuthentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neoSoft.formBasedAuthentication.model.User;
import com.neoSoft.formBasedAuthentication.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
//	alluser

	@GetMapping("/")
	public List<User> getAllUsers(){
		
		return this.userService.getAllUser();
	}
	
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String userName) {
		return this.userService.getUser(userName);
	}
	
	@PostMapping("/")
	public User add(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	
	@PostMapping("/databaseSave")
	public String save(@RequestBody User user) {
		System.out.println("in post method");
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.save(user);
		return "done";
	}

	
}
