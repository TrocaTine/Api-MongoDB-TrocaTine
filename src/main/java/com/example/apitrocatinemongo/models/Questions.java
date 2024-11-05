package com.example.apitrocatinemongo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "questions")
@Schema(description = "Document representing a question about a product")
public class Questions {

    @Id
    @Field(name = "_id")
    @Schema(description = "Unique identifier")
    private ObjectId id;

    @NotNull(message = "Product ID cannot be null.")
    @Field(name = "id_product")
    @Schema(description = "ID of the product", example = "1234")
    private Long idProduct;

    @NotNull(message = "User email cannot be null.")
    @Field(name = "email_user")
    @Schema(description = "User email", example = "user@example.com")
    private String emailUser;

    @NotNull(message = "Message cannot be null.")
    @Size(min = 2, message = "Message must have at least 2 characters.")
    @Schema(description = "User question", example = "What is the warranty period for this product?")
    private String message;

    @Field(name = "answers")
    @Schema(description = "List of answers")
    private List<Answers> answers;
}
