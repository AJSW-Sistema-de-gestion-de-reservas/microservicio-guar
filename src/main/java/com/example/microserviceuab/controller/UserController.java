package com.example.microserviceuab.controller;

import com.example.microserviceuab.dto.AuthenticateUserRequestDto;
import com.example.microserviceuab.dto.AuthenticateUserResponseDto;
import com.example.microserviceuab.dto.UserCreationRequestDto;
import com.example.microserviceuab.dto.UserCreationResponseDto;
import com.example.microserviceuab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/api/user/register")
    public ResponseEntity<UserCreationResponseDto> createUser(
        @RequestBody UserCreationRequestDto requestDto) {
        return ResponseEntity.ok(service.createUser(requestDto));
    }

    @PostMapping("/api/user/login")
    public ResponseEntity<AuthenticateUserResponseDto> authenticateUser(
        @RequestBody AuthenticateUserRequestDto requestDto) {
        return ResponseEntity.ok(service.authenticateUser(requestDto));
    }

}
