package com.example.apitrocatinemongo.config;

import com.example.apitrocatinemongo.client.Client;

import feign.RequestInterceptor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpenFeignConfig {


    private String token;
    private Client client;


    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            if (requiresToken(requestTemplate.url())) {
                requestTemplate.header("Authorization", "" + token);
            }
        };
    }

    private boolean requiresToken(String path) {
        List<String> openRoutes = Arrays.asList("/api/auth/login");
        return openRoutes.stream().noneMatch(path::startsWith);
    }




}
