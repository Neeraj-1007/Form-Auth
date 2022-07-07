package com.neoSoft.formBasedAuthentication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoSoft.formBasedAuthentication.Repository.UserRepository;
import com.neoSoft.formBasedAuthentication.model.User;



@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	List<User> list=new ArrayList<User>();
	
	public UserService() {
		list.add(new User("name1","name1@gmail.com","name@11"));
		list.add(new User("name2","name2@gmail.com","name@22"));
	}
	
	public List<User> getAllUser(){
		return list;
	}
	
	public User getUser(String userName) {
		return list.stream().filter((user)->userName.equals(user.getUserName())).findAny().orElse(null);
	}
	
	public User addUser(User user) {
		list.add(user);
		return user;
	}
	
	public void save(User user) {
		repo.save(user);
	}
	
	
}
