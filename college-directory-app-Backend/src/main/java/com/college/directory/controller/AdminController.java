package com.college.directory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.directory.model.User;
import com.college.directory.service.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<String> registerUser(@RequestBody User signupRequest){
		System.out.println("user " + signupRequest);
		String response = userService.addNewUser(signupRequest);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}

}
