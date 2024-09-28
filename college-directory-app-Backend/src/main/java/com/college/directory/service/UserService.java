package com.college.directory.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.college.directory.model.User;
import com.college.directory.model.UserPrinciple;
import com.college.directory.repository.IUserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private PasswordEncoder passEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    System.out.println("Attempting to load user: " + username);
	    Optional<User> opt = userRepo.findByUsername(username);
	    
	    if (opt.isPresent()) {
	        System.out.println("User found: " + opt.get());
	        return new UserPrinciple(opt.get());
	    } else {
	        System.out.println("User not found: " + username);
	        throw new UsernameNotFoundException("User not found: " + username);
	    }
	}


	public String addNewUser(User signupRequest) {
		if (signupRequest == null) {
			return "user is Empty";
		}
			signupRequest.setPassword(passEncoder.encode(signupRequest.getPassword()));
			
			Optional<User> opt = userRepo.findByUsername(signupRequest.getUsername());
			
			if(opt.isPresent()) {
				
				return "Bad Credential,Duplicate username Username must be Unique";
			}

			User user = new User();
			BeanUtils.copyProperties(signupRequest, user);

			int id = userRepo.save(user).getId();
			
			return "user successfully added with  " + id;
		}

}
