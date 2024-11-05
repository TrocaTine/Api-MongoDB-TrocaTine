package com.example.apitrocatinemongo.controllers;

import com.example.apitrocatinemongo.models.DTO.Request.FindReviewsProductRequesDTO;
import com.example.apitrocatinemongo.models.DTO.Request.SaveReviewProductRequestDTO;
import com.example.apitrocatinemongo.models.DTO.Response.FindReviewProductResponseDTO;
import com.example.apitrocatinemongo.models.DTO.Response.SaveReviewProductResponseDTO;
import com.example.apitrocatinemongo.models.DTO.Response.StandardResponseDTO;
import com.example.apitrocatinemongo.services.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@AllArgsConstructor
@Tag(name = "Reviews Controller", description = "Controller responsible for managing virtual currency produtos's reviews")
public class ReviewsController {

    private ReviewService reviewService;
    @Operation(summary = "Find product's review by product's id", description = "Retrieve all reviews associated with a specific product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reviews retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Product or User not found",
                    content = @Content(schema = @Schema(implementation = StandardResponseDTO.class)))
    })
    @PostMapping("/find-reviews")
    public StandardResponseDTO findReviews(@Valid @RequestBody FindReviewsProductRequesDTO request){
        FindReviewProductResponseDTO response = reviewService.findReviewProduct(request);
        return new StandardResponseDTO(false, response);
    }
    @Operation(summary = "Save product's review by product's id", description = "Save a reviews associated with a specific product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reviews saved successfully"),
            @ApiResponse(responseCode = "404", description = "Product or User not found",
                    content = @Content(schema = @Schema(implementation = StandardResponseDTO.class)))
    })
    @PostMapping("/save-review")
    public StandardResponseDTO saveReviews(@Valid @RequestBody SaveReviewProductRequestDTO request){
        SaveReviewProductResponseDTO response = reviewService.saveReviewProduct(request);
        return new StandardResponseDTO(false, response);
    }

}
