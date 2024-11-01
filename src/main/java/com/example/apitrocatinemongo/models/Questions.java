package com.example.apitrocatinemongo.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "questions")
public class Questions {

    @Id
    @Field(name = "_id")
    private ObjectId id;
    @NotNull
    @Field(name = "id_product")
    private Long idProduct;
    @NotNull
    @Field(name = "id_user")
    private Long idUser;
    @NotNull
    private String message;
    private List<Answers> answers;
}
