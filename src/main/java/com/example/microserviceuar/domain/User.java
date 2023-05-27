package com.example.microserviceuar.domain;

import jakarta.persistence.Id;
import java.util.UUID;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user")
public class User {

    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private String nationality;
    private boolean enabled;

    public String getFullName() {
        return firstName + " " + lastName;
    }

}
