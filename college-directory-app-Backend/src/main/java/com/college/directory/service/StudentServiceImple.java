package com.college.directory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.directory.model.Course;
import com.college.directory.model.Faculty;
import com.college.directory.model.Student;
import com.college.directory.repository.ICourseRepository;

import com.college.directory.repository.IFacultyRepository;
import com.college.directory.repository.IStudentRepository;

@Service
public class StudentServiceImple implements IStudentService {

	@Autowired
	private IStudentRepository studentRepository;

	@Autowired
	private ICourseRepository courseRepository;

	@Autowired
	private IFacultyRepository facultyRepository;

	@Override
	public Student getStudentProfile(Integer userId) {
		Optional<Student> studentProfileOpt = studentRepository.findByUserId(userId);
		if (studentProfileOpt.isPresent()) {
			Student studentProfile = studentProfileOpt.get();
			// Optionally, fetch courses and other academic details
			List<Course> courses = courseRepository.findByStudents(studentProfile);
			studentProfile.setCourses(courses);
			return studentProfile;
		}
		return null;
	}

	@Override
	public List<Faculty> getAssignedFacultyAdvisors(Integer studentId) {
		Optional<Student> studentProfileOpt = studentRepository.findById(studentId);
		if (studentProfileOpt.isPresent()) {
			return facultyRepository.findByDepartmentId(studentProfileOpt.get().getDepartment().getId());
		}
		return List.of();
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> list = studentRepository.findAll();
		return list;
	}

	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public String updateStudentById(int id, Student student) {
		System.out.println("StudentServiceImple.updateStudent()");
		Optional<Student> empOptional = studentRepository.findById(id);
		if (empOptional.isPresent()) {
			studentRepository.save(student);
			return "Student is updated";
		}
		return "Student is not found";
	}

	@Override
	public String deleteStudent(int id) {
		System.out.println("StudentServiceImple.deleteStudent()");
		Optional<Student> empOptional = studentRepository.findById(id);
		if (empOptional.isPresent()) {
			studentRepository.deleteById(id);
			return "Student is deleted with id " + id;
		}
		return "Student is not found for delete operation";
	}

}
