package com.college.directory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.college.directory.model.Faculty;
import com.college.directory.model.Student;
import com.college.directory.service.IStudentService;


@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    // Get student profile by user ID
    @GetMapping("/{userId}")
    public ResponseEntity<Student> getStudentProfile(@PathVariable Integer userId) {
        Student student = studentService.getStudentProfile(userId);
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }

    // Get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    // Save a new student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    // Update an existing student by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody Student student) {
        String response = studentService.updateStudentById(id, student);
        return new ResponseEntity<String>(response,HttpStatus.OK);
    }

    // Delete a student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        String response = studentService.deleteStudent(id);
        return response.contains("not found") ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(response) 
                                              : ResponseEntity.ok(response);
    }

    // Get assigned faculty advisors for a student
    @GetMapping("/{studentId}/advisors")
    public ResponseEntity<List<Faculty>> getAssignedFacultyAdvisors(@PathVariable Integer studentId) {
        List<Faculty> advisors = studentService.getAssignedFacultyAdvisors(studentId);
        return ResponseEntity.ok(advisors);
    }
}
