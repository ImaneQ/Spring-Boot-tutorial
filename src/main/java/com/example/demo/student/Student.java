package com.example.demo.student;

import jakarta.persistence.*;

import java.time.*;

@Entity
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long id;
    private LocalDate dateOfBirth;
    private String name;
    private String email;
    @Transient
    private Integer age;

    public Student(){

    }

    public Student(Long id, LocalDate dateOfBirth, String name, String email) {
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.email = email;
    }

    public Student(LocalDate dateOfBirth, String name, String email) {
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

public Integer getAge(){
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
}
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", dateOfBirth=" + dateOfBirth +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
