package com.college.directory.configur;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.college.directory.service.UserService;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	private JwtFilter jwtFilter;

    // UserDetailsService bean for userAuthentication
    @Bean
    UserDetailsService userDetailsService() {
		return new UserService();
	}

	 @Bean
	    public SecurityFilterChain securityChain(HttpSecurity httpSecurity) throws Exception {
	        return httpSecurity.csrf(csrf -> csrf.disable()) // Consider enabling if needed
	                .authorizeHttpRequests(auth -> auth
	                    .requestMatchers("/user/register", "/user/login").permitAll()
	                    .anyRequest().authenticated())
	                
//	                        .requestMatchers("/admin/**").hasAnyAuthority("STUDENT")
//	                        .requestMatchers("/user/**").hasAnyAuthority("FACULTY_MEMBER")
//	                        .requestMatchers("/adminuser/**").hasAnyAuthority("ADMIN", "ADMINISTRATOR")
//	                        .anyRequest().authenticated())
	                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	                .authenticationProvider(authenticationProvider())
	                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
	                .build();
	    }
	 
	
	@Bean
	public AuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

		System.out.println("daoAuthenticationProvider " +daoAuthenticationProvider);
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
}