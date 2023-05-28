package com.example.microserviceuab.dto;

import lombok.Data;

@Data
public class UserCreationRequestDto {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String nationality;

}
