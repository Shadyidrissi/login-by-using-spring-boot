package com.example.demo.controller;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping("/login")
	private ResponseEntity<String> createNewUser(@RequestBody Users users) {
	    // التحقق إذا كان البريد الإلكتروني موجودًا في قاعدة البيانات
	    boolean resultCheckEmail = userService.checkEmailUsing(users.getEmail());
	    if (resultCheckEmail) {
	        // إذا كان البريد موجودًا، إرجاع رسالة خطأ
	        return new ResponseEntity<>("البريد الإلكتروني موجود بالفعل", HttpStatus.CONFLICT); // 409 Conflict
	    }

	    // إذا لم يكن البريد موجودًا، إرجاع حالة ناجحة مع بيانات المستخدم
	    userService.saveUser(users); // إذا كانت لديك دالة لحفظ المستخدم الجديد
	    return new ResponseEntity<>("تم تسجيل الدخول بنجاح", HttpStatus.CREATED); // 201 Created
	}


}
