package com.example.microserviceuab.service;

import com.example.microserviceuab.domain.User;
import com.example.microserviceuab.dto.AuthenticateUserRequestDto;
import com.example.microserviceuab.dto.AuthenticateUserResponseDto;
import com.example.microserviceuab.dto.UserCreationRequestDto;
import com.example.microserviceuab.dto.UserCreationResponseDto;
import com.example.microserviceuab.exception.AuthenticationFailedException;
import com.example.microserviceuab.exception.UsernameAlreadyExists;
import com.example.microserviceuab.mapper.UserMapper;
import com.example.microserviceuab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImp(UserRepository repository, UserMapper mapper,
        BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserCreationResponseDto createUser(UserCreationRequestDto dto) {
        if (repository.existsByUsername(dto.getUsername())) {
            throw new UsernameAlreadyExists("");
        }

        String encodedPassword = encodePassword(dto.getPassword());

        User createdUser = mapper.userCreationRequestDtoToUser(dto);
        createdUser.setPassword(encodedPassword);

        repository.save(createdUser);

        return mapper.userToUserCreationResponseDto(createdUser);
    }

    @Override
    public AuthenticateUserResponseDto authenticateUser(AuthenticateUserRequestDto dto) {
        User user = repository.findByUsername(dto.getUsername());

        if (user != null && !verifyPassword(dto.getPassword(), user.getPassword())) {
            throw new AuthenticationFailedException("");
        }

        return new AuthenticateUserResponseDto(true); // TODO: Create and return a JWT.
    }

    private boolean verifyPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

}
