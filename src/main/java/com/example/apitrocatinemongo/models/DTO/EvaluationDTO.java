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
public class EvaluationDTO {
    private Long user;
    private int star;
    private String content;
    private LocalDate date;
}
