package com.example.apitrocatinemongo.controllers;

import com.example.apitrocatinemongo.models.DTO.Request.FindQuestionsByProductRequestDTO;
import com.example.apitrocatinemongo.models.DTO.Request.SaveQuestionsProductRequestDTO;
import com.example.apitrocatinemongo.models.DTO.Response.FindQuestionsByProductResponseDTO;
import com.example.apitrocatinemongo.models.DTO.Response.SaveQuestionsProductResponseDTO;
import com.example.apitrocatinemongo.models.DTO.Response.StandardResponseDTO;
import com.example.apitrocatinemongo.services.QuestionsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
@AllArgsConstructor
public class QuestionsController {

    private QuestionsService questionsService;

    @Operation(summary = "Find questions by product ID", description = "Retrieve all questions associated with a specific product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Questions retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Product or User not found",
                    content = @Content(schema = @Schema(implementation = StandardResponseDTO.class)))
    })
    @PostMapping("/find-questions")
    public StandardResponseDTO findQuestions(@RequestBody @Valid FindQuestionsByProductRequestDTO requestDTO){
        FindQuestionsByProductResponseDTO result = questionsService.findQuestionsByProductResponse(requestDTO);
        return new StandardResponseDTO(false, result);
    }

    @Operation(summary = "Save question for a product", description = "Save a question related to a specific product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Question saved successfully"),
            @ApiResponse(responseCode = "404", description = "Product or User not found",
                    content = @Content(schema = @Schema(implementation = StandardResponseDTO.class)))
    })
    @PostMapping("/save-questions")
    public StandardResponseDTO saveQuestions(@RequestBody @Valid SaveQuestionsProductRequestDTO requestDTO){
        SaveQuestionsProductResponseDTO result = questionsService.saveQuestionsProduct(requestDTO);
        return new StandardResponseDTO(false, result);
    }

}
