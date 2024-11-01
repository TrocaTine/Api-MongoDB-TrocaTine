package com.example.apitrocatinemongo.repositories;

import com.example.apitrocatinemongo.models.DTO.QuestionDTO;
import com.example.apitrocatinemongo.models.Questions;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Update;

import java.util.List;

public interface QuestionsRepository extends MongoRepository<Questions, String> {

    @Aggregation(pipeline = {
            "{ '$match': { 'id_product': ?0 } }",
            "{ '$unwind': { 'path': '$answers', 'preserveNullAndEmptyArrays': true } }",
            "{ '$sort': { 'answers.data': 1 } }",
            "{ '$group': { " +
                    "'_id': '$_id', " +
                    "'id_product': { '$first': '$id_product' }, " +
                    "'id_user': { '$first': '$id_user' }, " +
                    "'message': { '$first': '$message' }, " +
                    "'answers': { '$push': '$answers' } " +
                    "} }"
    })
    List<QuestionDTO> findQuestionsWithOrderedAnswers(Long productId);



}
