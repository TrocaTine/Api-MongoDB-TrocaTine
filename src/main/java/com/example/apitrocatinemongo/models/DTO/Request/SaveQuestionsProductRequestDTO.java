package com.example.apitrocatinemongo.models.DTO.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Data Transfer Object for saving a question about a product")
public record SaveQuestionsProductRequestDTO(

        @NotNull
        @Schema(description = "User's email address for authentication", example = "user@example.com")
        String email,

        @NotNull
        @Schema(description = "User's password for authentication", example = "securePassword123")
        String password,

        @NotNull
        @Schema(description = "ID of the product for which the question is being asked", example = "1234")
        Long idProduct,

        @NotNull
        @Schema(description = "The question message from the user", example = "What is the warranty period for this product?")
        String message
) {
}
