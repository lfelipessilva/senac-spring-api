package com.example.auth.domain.user;

public enum UserRole {
    admin("admin"),
    aluno("aluno"),
    professor("professor");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
