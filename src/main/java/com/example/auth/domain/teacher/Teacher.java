package com.example.auth.domain.teacher;

import com.example.auth.domain.user.User;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "teacher")
public class Teacher extends User {

    public Teacher(User user) {
        super(user.getEmail(), user.getSenha(), user.getRole());
    }
}