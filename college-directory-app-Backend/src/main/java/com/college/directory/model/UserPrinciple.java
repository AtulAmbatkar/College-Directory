package com.college.directory.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrinciple implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private Set<SimpleGrantedAuthority> authorities;
	
	public UserPrinciple(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
		 System.out.println("Loaded user: " + this.username + " with role: " + user.getRole() + " password " + this.password);
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
	    return true; // Customize based on your needs
	}

	@Override
	public boolean isAccountNonLocked() {
	    return true; // Customize based on your needs
	}

	@Override
	public boolean isCredentialsNonExpired() {
	    return true; // Customize based on your needs
	}

	@Override
	public boolean isEnabled() {
	    return true; // Customize based on your needs
	}

}
