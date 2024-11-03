package com.example.apitrocatinemongo.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDTO {
    private String email_user;
    private String message;
    private LocalDate data;
}
