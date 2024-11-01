package com.example.apitrocatinemongo.config;

import com.example.apitrocatinemongo.client.Client;
import com.example.apitrocatinemongo.models.DTO.LoginDTO;
import com.example.apitrocatinemongo.models.DTO.Response.StandardResponseDTO;
import com.example.apitrocatinemongo.models.DTO.Response.TokenResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenerateToken {

    private final Client client;
    private final OpenFeignConfig openFeignConfig;

    @Autowired
    public GenerateToken(Client client, OpenFeignConfig openFeignConfig) {
        this.client = client;
        this.openFeignConfig = openFeignConfig;
    }

    public void generatingToken(String email, String password) {
        StandardResponseDTO resultToken = client.token(new LoginDTO(email, password));
        ObjectMapper objectMapper = new ObjectMapper();
        TokenResponseDTO tokenResponse = objectMapper.convertValue(resultToken.data(), TokenResponseDTO.class);
        openFeignConfig.setToken(tokenResponse.token());
    }
}
