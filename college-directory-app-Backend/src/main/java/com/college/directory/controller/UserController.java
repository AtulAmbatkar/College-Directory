package com.college.directory.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.directory.configur.AuthenticationService;
import com.college.directory.configur.dto.LoginRequest;
import com.college.directory.configur.dto.LoginResponse;
import com.college.directory.model.Role;
import com.college.directory.model.User;
import com.college.directory.repository.IUserRepository;
import com.college.directory.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AuthenticationService jwtService;

	@Autowired
	private IUserRepository userRepository;

	@PostMapping("/register")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<String> registerUser(@RequestBody User signupRequest) {
		System.out.println("user " + signupRequest);
		String response = userService.addNewUser(signupRequest);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:3000/")
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginRequest request) {
		System.out.println("Enter into loginUser() method ");
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

			System.out.println("daoAuthentication " + authentication);

			if (authentication != null && authentication.isAuthenticated()) {
				String token = jwtService.generateToken(request.getUsername());
//	            String usserRole = request.getUsserRole();
				// Optional<User> findByUsername(String username);
				System.out.println("pppppp " +request.getUsername());
				Optional<User> opt = userRepository.findByUsername(request.getUsername());
				System.out.println(request.getUsername());
				System.out.println("rol:e " + opt);
				Role usserRole = null;
				if (opt.isPresent()) {
					User user = opt.get();
					usserRole = user.getRole();
					System.out.println("usserRole" + usserRole + "request.getUsserRole()" + request.getUsserRole() );
					if (usserRole != request.getUsserRole()) {
						return new ResponseEntity<>("User role mismatch", HttpStatus.BAD_REQUEST);
					}
				}
				System.out.println("token " + token);
				return ResponseEntity.ok(new LoginResponse(token, usserRole));
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
		}

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
	}
}
