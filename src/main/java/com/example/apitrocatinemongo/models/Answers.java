package com.example.apitrocatinemongo.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = "User ID must not be null")
    @Field(name = "id_user")
    private int idUser;

    @NotNull(message = "Message must not be null")
    @Size(min = 2, message = "Message must have at least 2 characters")
    private String message;

    @NotNull(message = "Date must not be null")
    private LocalDate data;
}
