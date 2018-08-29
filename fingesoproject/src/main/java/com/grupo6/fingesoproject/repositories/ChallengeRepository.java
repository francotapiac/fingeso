package com.grupo6.fingesoproject.repositories;

import com.grupo6.fingesoproject.models.Challenge;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChallengeRepository extends MongoRepository<Challenge, Long> {
    public Challenge findChallengetById(String id);
}
