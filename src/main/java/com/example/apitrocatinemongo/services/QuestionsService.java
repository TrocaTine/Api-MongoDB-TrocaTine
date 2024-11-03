package com.example.apitrocatinemongo.services;

import com.example.apitrocatinemongo.client.Client;
import com.example.apitrocatinemongo.config.GenerateToken;
import com.example.apitrocatinemongo.config.OpenFeignConfig;
import com.example.apitrocatinemongo.exception.NotFound;
import com.example.apitrocatinemongo.models.Answers;
import com.example.apitrocatinemongo.models.DTO.LoginDTO;
import com.example.apitrocatinemongo.models.DTO.QuestionDTO;
import com.example.apitrocatinemongo.models.DTO.Request.FindQuestionsByProductRequestDTO;
import com.example.apitrocatinemongo.models.DTO.Request.SaveQuestionsProductRequestDTO;
import com.example.apitrocatinemongo.models.DTO.Response.FindQuestionsByProductResponseDTO;
import com.example.apitrocatinemongo.models.DTO.Response.SaveQuestionsProductResponseDTO;
import com.example.apitrocatinemongo.models.DTO.Response.StandardResponseDTO;
import com.example.apitrocatinemongo.models.DTO.Response.TokenResponseDTO;
import com.example.apitrocatinemongo.models.Questions;
import com.example.apitrocatinemongo.repositories.QuestionsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class QuestionsService {

    private QuestionsRepository questionsRepository;
    private Client client;
    private GenerateToken generatingToken;


    public FindQuestionsByProductResponseDTO findQuestionsByProductResponse(FindQuestionsByProductRequestDTO request) {
        List<QuestionDTO> result = null;

        generatingToken.generatingToken(request.email(), request.password());

        boolean checkProductExist = client.checkProductExist(request.idProduct());
        if(checkProductExist){
            result = questionsRepository.findQuestionsWithOrderedAnswers(request.idProduct());
        }else{
            throw new NotFound("Not found product");
        }

        return new FindQuestionsByProductResponseDTO(result);
    }

    public SaveQuestionsProductResponseDTO saveQuestionsProduct(SaveQuestionsProductRequestDTO request){
        generatingToken.generatingToken(request.email(), request.password());
        StandardResponseDTO responseIdUSer = client.idUser(request.email());
        ObjectMapper objectMapper = new ObjectMapper();
        Long idUser = objectMapper.convertValue(responseIdUSer.data(), Long.TYPE);
        if(idUser == null){
            throw new NotFound("Not found user");
        }

        boolean checkProductExist = client.checkProductExist(request.idProduct());
        if(checkProductExist){
            Questions question = new Questions();
            question.setIdProduct(request.idProduct());
            question.setEmailUser(request.email());
            question.setMessage(request.message());
            question.setAnswers(new ArrayList<Answers>());
            questionsRepository.save(question);

        }else{
            throw new NotFound("Not found product");
        }
        return new SaveQuestionsProductResponseDTO(true);

    }











}
