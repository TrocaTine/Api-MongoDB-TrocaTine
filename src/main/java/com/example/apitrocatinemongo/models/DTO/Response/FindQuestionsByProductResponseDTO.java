package com.example.apitrocatinemongo.models.DTO.Response;

import com.example.apitrocatinemongo.models.DTO.QuestionDTO;

import java.util.List;

public record FindQuestionsByProductResponseDTO(
        List<QuestionDTO> questionDTOList
) {

}
