package com.grupo6.fingesoproject.repositories;

import com.grupo6.fingesoproject.models.Evaluation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EvaluationRapository extends MongoRepository<Evaluation, Long> {
    public Evaluation findEvaluationById(String id);
}
