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
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "reviews")
public class Reviews {
    @Id
    @NotNull
    private ObjectId id;
    @NotNull
    private Long idProduct;
    @NotNull
    private Long idUser;
    @NotNull
    @Min(value = 0, message = "star must be greater than 0")
    @Max(value = 5, message = "star must be less than 5")
    private int star;
    @NotNull
    private String content;
    @NotNull
    private LocalDate data;
}
