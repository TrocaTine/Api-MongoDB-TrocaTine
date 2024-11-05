package com.example.apitrocatinemongo.models.DTO.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Data Transfer Object for finding questions by product")
public record FindQuestionsByProductRequestDTO(

        @NotNull
        @Schema(description = "User's email address for authentication", example = "user@example.com")
        String email,

        @NotNull
        @Schema(description = "User's password for authentication", example = "securePassword123")
        String password,

        @NotNull
        @Schema(description = "ID of the product for which questions are being requested", example = "1234")
        Long idProduct
) {
}
