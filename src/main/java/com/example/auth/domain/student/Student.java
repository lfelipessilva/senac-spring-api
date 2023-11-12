package com.example.auth.domain.student;

import com.example.auth.domain.user.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "student")
public class Student extends User {

    public Student(User user) {
        super(user.getEmail(), user.getSenha(), user.getRole());
    }

    @Column
    private String course_id;
}