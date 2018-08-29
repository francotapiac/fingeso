package com.grupo6.fingesoproject.repositories;

import com.grupo6.fingesoproject.models.Evaluator;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EvaluatorRepository extends MongoRepository<Evaluator, Long> {
    public Evaluator findEvaluatorById(String id);
}
