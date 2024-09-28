package com.college.directory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.directory.model.Faculty;

@Repository
public interface IFacultyRepository extends JpaRepository<Faculty, Integer> {
	
	List<Faculty> findByDepartmentId(Integer integer);
}
