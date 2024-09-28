package com.college.directory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="username" , length=50, unique=true, nullable=false)
	private String username;
	
	@Column(name="password",length=255, nullable=false)
	private String password;
	
	@Column(name = "role")
    @Enumerated(EnumType.STRING) // If it's stored as a string in the DB
	private Role role;
	
	@Column(length=100, nullable=false)
	private String name;
	
	@Column(length=100, nullable=false, unique=true)
	private String email;
	
	@Column(name="phone", length=15)
	private Long phoneNo;

	public User() {
		super();
	}

	public User(Integer id, String username, String password, Role role, String name, String email, Long phoneNo) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", userrole=" + role + ", name="
				+ name + ", email=" + email + ", phoneNo=" + phoneNo + "]";
	}
}
