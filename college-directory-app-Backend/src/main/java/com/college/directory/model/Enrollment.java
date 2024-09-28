package com.college.directory.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "enrollments")
public class Enrollment  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Foreign key linking to the StudentProfile entity
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // Foreign key linking to the Course entity
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    // Default constructor
    public Enrollment() {
    }

    // Parameterized constructor
    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", student=" + student.getUser().getName() +
                ", course=" + course.getTitle() +
                '}';
    }
}
