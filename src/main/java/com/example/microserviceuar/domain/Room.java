package com.example.microserviceuar.domain;

import jakarta.persistence.Id;
import java.util.UUID;

public class Room {

    @Id
    private UUID id;
    private String name;
    private String capacity;
    
}
