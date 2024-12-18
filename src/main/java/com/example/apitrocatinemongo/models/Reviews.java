package com.example.apitrocatinemongo.models;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "reviews")
@Schema(description = "Document representing a product review")
public class Reviews {
    @Id
    @NotNull(message = "ID cannot be null.")
    @Schema(description = "Unique identifier")
    private ObjectId id;

    @NotNull(message = "Product ID cannot be null.")
    @Schema(description = "ID of the product", example = "1234")
    private Long idProduct;

    @NotNull(message = "User email cannot be null.")
    @Schema(description = "User email", example = "user@example.com")
    @Field(name = "email_user")
    private String emailUser;

    @NotNull(message = "Star rating cannot be null.")
    @Min(value = 0, message = "Star rating must be at least 0.")
    @Max(value = 5, message = "Star rating must be at most 5.")
    @Schema(description = "Star rating given by the user, from 0 to 5", example = "4")
    private int star;

    @NotNull(message = "Content cannot be null.")
    @Schema(description = "Content of the review", example = "Great product, highly recommend!")
    private String content;

    @NotNull(message = "Date cannot be null.")
    @Schema(description = "Date when the review was posted", example = "2024-10-10")
    private LocalDate data;

}
