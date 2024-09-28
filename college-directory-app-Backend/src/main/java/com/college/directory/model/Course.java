package com.college.directory.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Title of the course
    private String title;

    // Description of the course content
    private String description;

    // Foreign key linking to the Department entity
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    // Foreign key linking to the FacultyProfile entity
    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;
    
 // Establishing a many-to-many relationship with Student
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "enrollment",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    // Default constructor
    public Course() {
    }

    // Parameterized constructor
    public Course(String title, String description, Department department, Faculty faculty) {
        this.title = title;
        this.description = description;
        this.department = department;
        this.faculty = faculty;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    
    public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", department=" + department.getName() +
                ", faculty=" + faculty.getUser().getName() +
                '}';
    }
}
