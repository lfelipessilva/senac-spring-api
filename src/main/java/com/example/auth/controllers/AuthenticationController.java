package com.example.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.domain.user.AuthenticationDTO;
import com.example.auth.domain.user.LoginResponseDTO;
import com.example.auth.domain.user.RegisterDTO;
import com.example.auth.domain.user.User;
import com.example.auth.infra.security.TokenService;
import com.example.auth.repositories.UserRepository;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return new ResponseEntity<>(new LoginResponseDTO(token), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO data) {
        if (this.repository.findByEmail(data.email()) != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        User newUser = new User(data.email(), encryptedPassword, data.role());

        this.repository.save(newUser);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
