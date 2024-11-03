package com.example.apitrocatinemongo.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {

    private String id;
    private String id_product;
    private String email_user;
    private String message;
    private List<AnswerDTO> answers;
}
