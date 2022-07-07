package com.neoSoft.formBasedAuthentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {

	
	@GetMapping("/signin")
	public String signIn() {
		return "Login";
	}
	
	@GetMapping("/register")
	public String signInTest() {
		return "Login";
	}
}
