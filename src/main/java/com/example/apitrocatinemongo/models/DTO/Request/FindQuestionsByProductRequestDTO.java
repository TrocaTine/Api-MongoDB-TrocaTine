package com.example.apitrocatinemongo.models.DTO.Request;

import jakarta.validation.constraints.NotNull;

public record FindQuestionsByProductRequestDTO(
        @NotNull
        String email,
        @NotNull
        String password,
        @NotNull
        Long idProduct
) {
}
