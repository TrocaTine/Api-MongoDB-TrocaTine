package com.example.apitrocatinemongo.models.DTO.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Data Transfer Object for saving a product review")
public record SaveReviewProductRequestDTO(

        @NotNull
        @Schema(description = "User's email address for authentication", example = "user@example.com")
        String email,

        @NotNull
        @Schema(description = "User's password for authentication", example = "securePassword123")
        String password,

        @NotNull
        @Schema(description = "ID of the product being reviewed", example = "1234")
        Long idProduct,

        @NotNull
        @Schema(description = "The review message from the user", example = "This product is fantastic!")
        String message,

        @NotNull
        @Min(value = 0, message = "Star rating must be greater than or equal to 0.")
        @Max(value = 5, message = "Star rating must be less than or equal to 5.")
        @Schema(description = "Star rating given by the user, from 0 to 5", example = "4")
        int star
) {
}
