package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.Users;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
//	@GetMapping('/login')
//	private boolean loginRequest (@RequestBody Users users) {
//	}
	
	@PostMapping("/login")
	private String createNewUser(@RequestBody Users users) {
	    boolean resultCheckEmail = userService.checkUserEmail(users.getEmail());
	    if (resultCheckEmail) {
	        return "Email already exists.";
	    }
	    return "Done Login";
	}

}
