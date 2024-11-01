package com.example.apitrocatinemongo.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Answers {
    @NotNull
    @Field(name = "id_user")
    private int idUser;
    @NotNull
    private String message;
    @NotNull
    private LocalDate data;
}
