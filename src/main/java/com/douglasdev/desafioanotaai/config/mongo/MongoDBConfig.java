package com.douglasdev.desafioanotaai.config.mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoDBConfig {

    @Bean //Cria conexao com DB MongoDB.
    public MongoDatabaseFactory mongoDatabaseFactory(){
        return new SimpleMongoClientDatabaseFactory("mongodb://localhost:27017/product-catalog");
    }

    @Bean //Fornece uma interface para interagir com o banco de dados de forma mais facil
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoDatabaseFactory());
    }
}
