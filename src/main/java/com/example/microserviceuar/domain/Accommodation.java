package com.example.microserviceuar.domain;

import jakarta.persistence.Id;
import java.util.List;
import java.util.UUID;
import lombok.Data;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "accommodation")
public class Accommodation {

    @Id
    private UUID id;
    private UUID ownerId;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private String name;
    private String address;
    private String city;
    private String province;
    private String postalCode;
    private List<Room> rooms;
    private boolean enabled;

    public String getFullAddress() {
        return String.format("%s, %s %s, %s", address, city, postalCode, province);
    }
    
}
