package com.example.apitrocatinemongo.models.DTO.Response;

import com.example.apitrocatinemongo.models.DTO.EvaluationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FindReviewProductResponseDTO {
    private Long productId;
    private double averageStar;
    private List<EvaluationDTO> evaluations;
}
