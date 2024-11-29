package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.module.Users;
import com.example.demo.reposetory.UserReposetory;

@Service
public class UserService {
	@Autowired
	private UserReposetory userReposetory;
	
	public boolean checkEmailUsing(String email) {
	    return userReposetory.existsByEmail(email);
	}

	
	public void saveUser(Users users) {
	    userReposetory.save(users);
	}

}
