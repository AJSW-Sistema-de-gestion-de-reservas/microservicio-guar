package com.example.microserviceuab.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponseDto {

    private int errorCode;
    private String message;

}
