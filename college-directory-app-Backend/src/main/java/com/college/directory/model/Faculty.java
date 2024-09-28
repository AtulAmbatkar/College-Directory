package com.college.directory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "faculty_profiles")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Foreign key linking to the User entity
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // URL or path to the faculty member's profile photo
    private String photo;

    // Foreign key linking to the Department entity
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    // Office hours for the faculty member
    private String officeHours;

    // Default constructor
    public Faculty() {
    }

    // Parameterized constructor
    public Faculty(User user, String photo, Department department, String officeHours) {
        this.user = user;
        this.photo = photo;
        this.department = department;
        this.officeHours = officeHours;
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

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    @Override
    public String toString() {
        return "FacultyProfile{" +
                "id=" + id +
                ", user=" + user.getName() +
                ", photo='" + photo + '\'' +
                ", department=" + department.getName() +
                ", officeHours='" + officeHours + '\'' +
                '}';
    }
}
