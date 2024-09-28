package com.college.directory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.directory.model.Course;
import com.college.directory.model.Student;

public interface ICourseRepository extends JpaRepository<Course,Integer> {
	
    List<Course> findByStudents(Student studentProfile);
}
