package com.college.directory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.directory.model.Faculty;
import com.college.directory.service.IFacultyService;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

    @Autowired
    private IFacultyService facultyService;

    // Get faculty profile by user ID
    @GetMapping("/{userId}")
    public ResponseEntity<Faculty> getFacultyProfile(@PathVariable Integer userId) {
        Optional<Faculty> faculty = facultyService.getFacultyById(userId);  // Adjust this method in your service if needed
       return new ResponseEntity<Faculty>(faculty.get(),HttpStatus.ACCEPTED);
    }

    // Get all faculty
    @GetMapping
    public ResponseEntity<List<Faculty>> getAllFaculty() {
        List<Faculty> faculty = facultyService.getAllFaculty();
        return ResponseEntity.ok(faculty);
    }

    // Save a new faculty
    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {  // Changed method name
        Faculty savedFaculty = facultyService.save(faculty);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFaculty);
    }

    // Update an existing faculty by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateFaculty(@PathVariable int id, @RequestBody Faculty faculty) {  // Changed method name
        String response = facultyService.updateFacultyById(id, faculty);  // Fixed method name
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Delete a faculty by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFaculty(@PathVariable int id) {
        String response = facultyService.deleteFaculty(id);  // Fixed method name
        return response.contains("not found") ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(response)
                                               : ResponseEntity.ok(response);
    }
}

