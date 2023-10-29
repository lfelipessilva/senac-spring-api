package com.example.auth.domain.user;

public enum UserRole {
    ADMIN("admin"),
    STUDENT("student"),
    TEACHER("teacher");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
