package com.example.microserviceuab.repository;

import com.example.microserviceuab.domain.User;
import org.springframework.data.mongodb.repository.ExistsQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);

    @ExistsQuery("{ 'username': ?0}")
    boolean existsByUsername(String username);

}
