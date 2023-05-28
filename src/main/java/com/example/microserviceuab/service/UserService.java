package com.example.microserviceuab.service;

import com.example.microserviceuab.dto.AuthenticateUserRequestDto;
import com.example.microserviceuab.dto.AuthenticateUserResponseDto;
import com.example.microserviceuab.dto.UserCreationRequestDto;
import com.example.microserviceuab.dto.UserCreationResponseDto;

public interface UserService {

    UserCreationResponseDto createUser(UserCreationRequestDto dto);

    AuthenticateUserResponseDto authenticateUser(AuthenticateUserRequestDto dto);

}