package com.example.apitrocatinemongo.controllers;

import com.example.apitrocatinemongo.models.DTO.Request.FindQuestionsByProductRequestDTO;
import com.example.apitrocatinemongo.models.DTO.Request.SaveQuestionsProductRequestDTO;
import com.example.apitrocatinemongo.models.DTO.Response.FindQuestionsByProductResponseDTO;
import com.example.apitrocatinemongo.models.DTO.Response.SaveQuestionsProductResponseDTO;
import com.example.apitrocatinemongo.models.DTO.Response.StandardResponseDTO;
import com.example.apitrocatinemongo.services.QuestionsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
@AllArgsConstructor
public class QuestionsController {

    private QuestionsService questionsService;

    @GetMapping("/find-questions")
    public StandardResponseDTO findQuestions(@RequestBody @Valid FindQuestionsByProductRequestDTO requestDTO){
        FindQuestionsByProductResponseDTO result = questionsService.findQuestionsByProductResponse(requestDTO);
        return new StandardResponseDTO(false, result);
    }

    @PostMapping("/save-questions")
    public StandardResponseDTO saveQuestions(@RequestBody @Valid SaveQuestionsProductRequestDTO requestDTO){
        SaveQuestionsProductResponseDTO result = questionsService.saveQuestionsProduct(requestDTO);
        return new StandardResponseDTO(false, result);
    }
}
