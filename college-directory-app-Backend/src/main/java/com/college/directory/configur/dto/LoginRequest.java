package com.college.directory.configur.dto;

import com.college.directory.model.Role;

public class LoginRequest {

	private String username;
	private String password;
	private Role usserRole;
	
	public LoginRequest(String username, String password, Role usserRole) {
		super();
		this.username = username;
		this.password = password;
		this.usserRole = usserRole;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getUsserRole() {
		return usserRole;
	}
	public void setUsserRole(Role usserRole) {
		this.usserRole = usserRole;
	}
	@Override
	public String toString() {
		return "LoginRequest [username=" + username + ", password=" + password + ", usserRole=" + usserRole + "]";
	}
	
}
