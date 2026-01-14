package com.victornext.security.controller;

import com.victornext.security.dto.request.LoginRequest;
import com.victornext.security.dto.request.RegisterUserRequest;
import com.victornext.security.dto.response.LoginResponse;
import com.victornext.security.dto.response.RegisterUserResponse;
import com.victornext.security.entity.User;
import com.victornext.security.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


    private final UserRepository repository;


    public AuthController(UserRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return null;
    }


    public ResponseEntity<RegisterUserResponse> register(@Valid @RequestBody RegisterUserRequest request){
        User newUser = new User();
        newUser.setPassword(request.pwassword()); //Dava pra ser tudo com mapper aqui, seria o ideal, mas como ta sendo so revisado....
        newUser.setEmail(request.email());
        newUser.setName(request.name());

        repository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(new RegisterUserResponse(newUser.getName(), newUser.getEmail()));
    }
}
