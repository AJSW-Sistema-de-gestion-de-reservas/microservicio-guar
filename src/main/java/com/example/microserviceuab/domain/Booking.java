package com.example.microserviceuab.domain;

import java.util.UUID;
import org.springframework.data.annotation.Id;

public class Booking {

    @Id
    private UUID id;
    private UUID hotelId;
    private UUID userId;
    private double amount;
    private boolean paid;

}
