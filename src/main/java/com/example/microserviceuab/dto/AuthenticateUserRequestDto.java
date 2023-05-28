package com.example.microserviceuab.dto;

import lombok.Data;

@Data
public class AuthenticateUserRequestDto {

    private String username;
    private String password;

}
