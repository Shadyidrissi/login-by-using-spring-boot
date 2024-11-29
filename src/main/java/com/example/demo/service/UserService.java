package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.reposetory.UserReposetory;

@Service
public class UserService {
	@Autowired
	private UserReposetory userReposetory;
	
	public boolean checkUserEmail(String email) {
		return userReposetory.checkEmailUsing(email);
	}
}
