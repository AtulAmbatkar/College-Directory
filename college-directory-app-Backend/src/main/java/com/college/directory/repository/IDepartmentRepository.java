package com.college.directory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.directory.model.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {

}
