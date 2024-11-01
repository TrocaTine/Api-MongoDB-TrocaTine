package com.example.apitrocatinemongo.models.DTO;


import jakarta.validation.constraints.NotNull;



public record LoginDTO(
        @NotNull
        String email,
        @NotNull
        String password) {


}

