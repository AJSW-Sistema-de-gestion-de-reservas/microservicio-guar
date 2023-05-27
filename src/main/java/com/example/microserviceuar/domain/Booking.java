package com.example.microserviceuar.domain;

import jakarta.persistence.Id;
import java.util.UUID;

public class Booking {

    @Id
    private UUID id;
    private UUID hotelId;
    private UUID userId;
    private double amount;
    private boolean paid;
    
}
