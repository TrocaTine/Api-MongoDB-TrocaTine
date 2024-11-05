package com.example.apitrocatinemongo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@OpenAPIDefinition(info = @Info(
        title = "Api TrocaTine MongoDB",
        description = "API is a CRUD with the tables necessary for the application TrocaTine to function, on mongoDB",
        version = "1"))
@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.apitrocatinemongo.client")
public class ApiTrocaTineMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiTrocaTineMongoApplication.class, args);
    }

}
