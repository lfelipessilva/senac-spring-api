package com.example.auth.domain.user;

public record RegisterDTO(String email, String senha, UserRole role) {
}
