package com.college.directory.configur.dto;

import com.college.directory.model.Role;

public class LoginResponse {

	// for takon
	private String token;
	
	//for role
	private Role usserRole;

	public LoginResponse(String token, Role usserRole2) {
		super();
		this.token = token;
		this.usserRole= usserRole2;
	}

	// get token as response
	public String getToken() {
		return token;
	}
	
	//get role
	public Role getUsserRole() {
		return usserRole;
	}
}
