package com.college.directory.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.directory.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);
	
	List<String> findByname(String name);

}
