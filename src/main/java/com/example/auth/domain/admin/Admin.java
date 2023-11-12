package com.example.auth.domain.admin;

import com.example.auth.domain.user.User;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "admin")
public class Admin extends User {

    public Admin(User user) {
        super(user.getEmail(), user.getSenha(), user.getRole());
    }
}