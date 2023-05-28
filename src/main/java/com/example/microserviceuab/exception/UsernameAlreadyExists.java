package com.example.microserviceuab.exception;

public class UsernameAlreadyExists extends RuntimeException {

    public UsernameAlreadyExists(String message) {
        super(message);
    }

}
