package com.college.directory.service;

import java.util.List;
import com.college.directory.model.Faculty;
import com.college.directory.model.Student;

public interface IStudentService {

	public Student getStudentProfile(Integer userId);

	public List<Faculty> getAssignedFacultyAdvisors(Integer studentId);

	public List<Student> getAllStudents();

	public Student save(Student student);

	public String updateStudentById(int id, Student student);

	public String deleteStudent(int id);

}
