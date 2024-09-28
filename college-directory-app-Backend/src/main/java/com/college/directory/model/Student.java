package com.college.directory.model;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_profiles")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Foreign key relationship with the User entity
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Field to store the photo URL or file path
    private String photo;

    // Foreign key relationship with the Department entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    // Field to store the student's year of study (e.g., Freshman, Sophomore, etc.)
    private String year;

    // Establishing a many-to-many relationship with Course
    @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
    private List<Course> courses;
    
    // Default constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(User user, String photo, Department department, String year) {
        this.user = user;
        this.photo = photo;
        this.department = department;
        this.year = year;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    

    public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
    public String toString() {
        return "StudentProfile{" +
                "id=" + id +
                ", user=" + user +
                ", photo='" + photo + '\'' +
                ", department=" + department +
                ", year='" + year + '\'' +
                '}';
    }
}
