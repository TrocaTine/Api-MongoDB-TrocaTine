package com.example.apitrocatinemongo.repositories;

import com.example.apitrocatinemongo.models.DTO.Response.FindReviewProductResponseDTO;
import com.example.apitrocatinemongo.models.Reviews;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewsRepository extends MongoRepository<Reviews, String> {

    @Aggregation(pipeline = {
            "{ '$match': { 'idProduct': ?0 } }",
            "{ '$group': { '_id': '$idProduct', " +
                    "'averageStar': { '$avg': '$star' }, " +
                    "'evaluations': { '$push': { 'user': '$email_user', 'star': '$star', 'content': '$content', 'date': '$data' } } } }",
            "{ '$project': { '_id': 0, 'productId': '$_id', 'averageStar': 1, 'evaluations': 1 } }"
    })
    FindReviewProductResponseDTO findProductReviews(Long idProduct);
}
