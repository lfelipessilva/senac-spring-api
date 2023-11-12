package com.example.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auth.domain.admin.Admin;
import com.example.auth.domain.student.Student;
import com.example.auth.domain.teacher.Teacher;
import com.example.auth.domain.user.User;
import com.example.auth.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public User addUser(User user) {
    switch (user.getRole().toString()) {
      case "admin":
        user = new Admin(user);
        break;
      case "teacher":
        user = new Teacher(user);
        break;
      default:
        user = new Student(user);
        break;
    }

    return userRepository.save(user);
  }
}
