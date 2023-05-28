package com.example.microserviceuab.domain;

import java.util.UUID;
import org.springframework.data.annotation.Id;

public class Room {

    @Id
    private UUID id;
    private String name;
    private String capacity;

}
