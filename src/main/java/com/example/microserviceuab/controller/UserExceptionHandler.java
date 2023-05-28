package com.example.microserviceuab.controller;

import com.example.microserviceuab.dto.ErrorResponseDto;
import com.example.microserviceuab.exception.AuthenticationFailedException;
import com.example.microserviceuab.exception.UsernameAlreadyExists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice(assignableTypes = UserController.class)
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class UserExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserExceptionHandler.class);

    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<ErrorResponseDto> handleAuthenticationFailed(
        AuthenticationFailedException ex) {
        LOGGER.error("handleAuthenticationFailed", ex);

        ErrorResponseDto dto = ErrorResponseDto.builder()
            .errorCode(401)
            .message("Unauthorized")
            .build();

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dto);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseDto> handleUsernameAlreadyExists(UsernameAlreadyExists ex) {
        LOGGER.error("handleUsernameAlreadyExists", ex);

        ErrorResponseDto dto = ErrorResponseDto.builder()
            .errorCode(409)
            .message("Username already exists")
            .build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(dto);
    }

}
