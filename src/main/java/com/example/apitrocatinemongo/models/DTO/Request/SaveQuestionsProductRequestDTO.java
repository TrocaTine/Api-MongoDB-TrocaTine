
package com.example.apitrocatinemongo.models.DTO.Request;

import jakarta.validation.constraints.NotNull;

public record SaveQuestionsProductRequestDTO(
        @NotNull
        String email,
        @NotNull
        String password,
        @NotNull
        Long idProduct,
        @NotNull
        String message
) {
}
