package com.example.microserviceuab.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.UuidRepresentation;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories({"com.example.microserviceuab.repository"})
public class MongoConfig extends AbstractMongoClientConfiguration {

    private final String url;
    private final String database;

    public MongoConfig(@Value("${spring.data.mongodb.url}") String url,
        @Value("${spring.data.mongodb.database}") String database) {
        this.url = url;
        this.database = database;
    }

    @Override
    protected @NotNull String getDatabaseName() {
        return database;
    }

    @Bean
    public @NotNull MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString(url);

        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .uuidRepresentation(UuidRepresentation.STANDARD)
            .applyConnectionString(connectionString)
            .build();

        return MongoClients.create(mongoClientSettings);
    }

}
