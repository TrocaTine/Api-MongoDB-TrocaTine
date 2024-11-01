package com.example.apitrocatinemongo.models.DTO.Request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record SaveReviewProductRequestDTO(

        @NotNull
        String email,
        @NotNull
        String password,
        @NotNull
        Long idProduct,
        @NotNull
        String message,
        @NotNull
        @Min(value = 0, message = "star must be greater than 0")
        @Max(value = 5, message = "star must be less than 5")
        int star
) {
}
