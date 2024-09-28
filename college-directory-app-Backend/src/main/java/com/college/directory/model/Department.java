package com.college.directory.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 500)
    private String description;

    // One-to-many relationship with StudentProfile
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Student> students;

    // One-to-many relationship with FacultyProfile
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Faculty> facultyMembers;

    // One-to-many relationship with AdministratorProfile
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Administrator> administrators;

    // One-to-many relationship with Course
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Course> courses;

    // Default constructor
    public Department() {
    }

    // Parameterized constructor
    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Faculty> getFacultyMembers() {
        return facultyMembers;
    }

    public void setFacultyMembers(List<Faculty> facultyMembers) {
        this.facultyMembers = facultyMembers;
    }

    public List<Administrator> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(List<Administrator> administrators) {
        this.administrators = administrators;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
