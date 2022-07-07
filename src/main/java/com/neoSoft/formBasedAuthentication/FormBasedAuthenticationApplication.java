package com.neoSoft.formBasedAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.neoSoft.formBasedAuthentication.Repository.UserRepository;
import com.neoSoft.formBasedAuthentication.model.User;

@SpringBootApplication
public class FormBasedAuthenticationApplication implements CommandLineRunner{

	@Autowired
	private UserRepository repo; 
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(FormBasedAuthenticationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user=new User();
		user.setEmail("neeraj@gamilcom");
		user.setPassword(passwordEncoder.encode("neeraj"));
		user.setRole("ROLE_ADMIN");
		user.setUserName("Neeraj");
		
		repo.save(user);
		
		User user1=new User();
		user1.setEmail("pooja@gamilcom");
		user1.setPassword(passwordEncoder.encode("pooja"));
		user1.setRole("ROLE_LEAD");
		user1.setUserName("Pooja");
		
		repo.save(user1);
		
	}

}
