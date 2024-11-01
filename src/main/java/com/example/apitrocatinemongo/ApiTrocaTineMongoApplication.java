package com.example.apitrocatinemongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.apitrocatinemongo.client")
public class ApiTrocaTineMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiTrocaTineMongoApplication.class, args);
    }

}
