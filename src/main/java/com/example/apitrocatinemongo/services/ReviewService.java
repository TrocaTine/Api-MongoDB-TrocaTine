package com.example.apitrocatinemongo.services;

import com.example.apitrocatinemongo.client.Client;
import com.example.apitrocatinemongo.config.GenerateToken;
import com.example.apitrocatinemongo.exception.NotFound;
import com.example.apitrocatinemongo.models.Answers;
import com.example.apitrocatinemongo.models.DTO.Request.FindReviewsProductRequesDTO;
import com.example.apitrocatinemongo.models.DTO.Request.SaveReviewProductRequestDTO;
import com.example.apitrocatinemongo.models.DTO.Response.FindReviewProductResponseDTO;
import com.example.apitrocatinemongo.models.DTO.Response.SaveQuestionsProductResponseDTO;
import com.example.apitrocatinemongo.models.DTO.Response.SaveReviewProductResponseDTO;
import com.example.apitrocatinemongo.models.DTO.Response.StandardResponseDTO;
import com.example.apitrocatinemongo.models.Questions;
import com.example.apitrocatinemongo.models.Reviews;
import com.example.apitrocatinemongo.repositories.ReviewsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
@AllArgsConstructor
public class ReviewService {


    private ReviewsRepository reviewRepository;
    private GenerateToken generatingToken;
    private Client client;

    public FindReviewProductResponseDTO findReviewProduct(FindReviewsProductRequesDTO request) {
        FindReviewProductResponseDTO result = null;

        generatingToken.generatingToken(request.email(), request.password());
        StandardResponseDTO responseIdUser = client.idUser(request.email());
        ObjectMapper objectMapper = new ObjectMapper();
        Long idUser = objectMapper.convertValue(responseIdUser.data(), Long.TYPE);
        if(idUser == null){
            throw new NotFound("Not found user");
        }

        boolean checkProductExist = client.checkProductExist(request.idProduct());
        if(checkProductExist){
            result = reviewRepository.findProductReviews(request.idProduct());
        }else{
            throw new NotFound("Not found product");
        }

        return result;
    }



    public SaveReviewProductResponseDTO saveReviewProduct(SaveReviewProductRequestDTO request){
        generatingToken.generatingToken(request.email(), request.password());
        StandardResponseDTO responseIdUSer = client.idUser(request.email());
        ObjectMapper objectMapper = new ObjectMapper();
        Long idUser = objectMapper.convertValue(responseIdUSer.data(), Long.TYPE);
        if(idUser == null){
            throw new NotFound("Not found user");
        }

        boolean checkProductExist = client.checkProductExist(request.idProduct());
        if(checkProductExist){
            Reviews reviews = new Reviews();
            reviews.setIdProduct(request.idProduct());
            reviews.setEmailUser(request.email());
            reviews.setContent(request.message());
            reviews.setStar(reviews.getStar());
            reviews.setData(LocalDate.now());
            reviewRepository.save(reviews);
            return new SaveReviewProductResponseDTO(true);

        }else {
            throw new NotFound("Not found product");
        }
    }
}