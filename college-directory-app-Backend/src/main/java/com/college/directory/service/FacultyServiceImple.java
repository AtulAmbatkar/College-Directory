package com.college.directory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.directory.model.Faculty;
import com.college.directory.repository.IFacultyRepository;

@Service
public class FacultyServiceImple implements IFacultyService{
	
	@Autowired
	public IFacultyRepository facultyRepository;

	@Override
	public Optional<Faculty> getFacultyById(Integer id) {
		return facultyRepository.findById(id);
	}
	
	@Override
	public List<Faculty> getAllFaculty() {
		List<Faculty> list = facultyRepository.findAll();
		return list;
	}

	public Faculty save(Faculty faculty) {
		return facultyRepository.save(faculty);
	}

	@Override
	public String updateFacultyById(int id, Faculty faculty) {
		System.out.println("FacultyServiceImple.updateFaculty()");
		Optional<Faculty> empOptional = facultyRepository.findById(id);
		if (empOptional.isPresent()) {
			facultyRepository.save(faculty);
			return "Faculty is updated";
		}
		return "Faculty is not found";
	}

	@Override
	public String deleteFaculty(int id) {
		System.out.println("FacultyServiceImple.deleteFaculty()");
		Optional<Faculty> empOptional = facultyRepository.findById(id);
		if (empOptional.isPresent()) {
			facultyRepository.deleteById(id);
			return "Faculty is deleted with id " + id;
		}
		return "Faculty is not found for delete operation";
	}
}
