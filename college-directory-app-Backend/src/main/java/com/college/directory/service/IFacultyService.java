package com.college.directory.service;

import java.util.List;
import java.util.Optional;

import com.college.directory.model.Faculty;

public interface IFacultyService {
	
	public List<Faculty> getAllFaculty();

	public Faculty save(Faculty faculty);

	public String updateFacultyById(int id, Faculty faculty);

	public String deleteFaculty(int id);

	Optional<Faculty> getFacultyById(Integer userid);

}
