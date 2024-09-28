package com.college.directory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.directory.model.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {
	
	Optional<Student> findByUserId(Integer userId);

}
