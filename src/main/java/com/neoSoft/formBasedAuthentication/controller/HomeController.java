package com.neoSoft.formBasedAuthentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/public")
public class HomeController {


	@GetMapping("/home")
	public String getHome() {
		return "Home";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "Login";
	}
	
	@GetMapping("/register")
	public String getRegister() {
		return "Register";
	}
	@GetMapping("/logout")
	public String logout() {
		return "Login";
	}
}
