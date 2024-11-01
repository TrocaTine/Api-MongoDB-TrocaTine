package com.example.apitrocatinemongo.controllers;

import com.example.apitrocatinemongo.models.DTO.Request.FindReviewsProductRequesDTO;
import com.example.apitrocatinemongo.models.DTO.Request.SaveReviewProductRequestDTO;
import com.example.apitrocatinemongo.models.DTO.Response.FindReviewProductResponseDTO;
import com.example.apitrocatinemongo.models.DTO.Response.SaveReviewProductResponseDTO;
import com.example.apitrocatinemongo.models.DTO.Response.StandardResponseDTO;
import com.example.apitrocatinemongo.services.ReviewService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@AllArgsConstructor
public class ReviewsController {

    private ReviewService reviewService;

    @PostMapping("/find-reviews")
    public StandardResponseDTO findReviews(@Valid @RequestBody FindReviewsProductRequesDTO request){
        FindReviewProductResponseDTO response = reviewService.findReviewProduct(request);
        return new StandardResponseDTO(false, response);
    }


    @PostMapping("/save-review")
    public StandardResponseDTO saveReviews(@Valid @RequestBody SaveReviewProductRequestDTO request){
        SaveReviewProductResponseDTO response = reviewService.saveReviewProduct(request);
        return new StandardResponseDTO(false, response);
    }

}
