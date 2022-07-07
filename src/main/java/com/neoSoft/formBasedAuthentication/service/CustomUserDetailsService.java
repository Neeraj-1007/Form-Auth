package com.neoSoft.formBasedAuthentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neoSoft.formBasedAuthentication.Repository.UserRepository;
import com.neoSoft.formBasedAuthentication.model.CustomUserDetail;
import com.neoSoft.formBasedAuthentication.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=this.repo.findByUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException("Not Found");
		}
		return new CustomUserDetail(user);
	}

	
}
