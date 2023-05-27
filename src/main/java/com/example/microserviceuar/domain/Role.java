package com.example.microserviceuar.domain;

import jakarta.persistence.Id;
import java.util.UUID;
import lombok.Data;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "role")
public class Role {

    @Id
    private UUID id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private String name;

}
