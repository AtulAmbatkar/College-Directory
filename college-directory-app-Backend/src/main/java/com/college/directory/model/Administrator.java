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
@Table(name = "administrator_profiles")
public class Administrator  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Foreign key linking to the User entity
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // URL or path to the administrator's profile photo
    private String photo;

    // Foreign key linking to the Department entity
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    // Default constructor
    public Administrator() {
    }

    // Parameterized constructor
    public Administrator(User user, String photo, Department department) {
        this.user = user;
        this.photo = photo;
        this.department = department;
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

    @Override
    public String toString() {
        return "AdministratorProfile{" +
                "id=" + id +
                ", user=" + user.getName() +
                ", photo='" + photo + '\'' +
                ", department=" + department.getName() +
                '}';
    }
}
