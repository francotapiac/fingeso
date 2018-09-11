package com.grupo6.fingesoproject.repositories;

import com.grupo6.fingesoproject.models.Challenge;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChallengeRepository extends MongoRepository<Challenge, String> {
    Challenge findChallengeById(String id);
    public List<Challenge> findByTitle(String title);
    public List<Challenge> findByTitleLike(String title);
    public List<Challenge> findByDescriptionLike(String description);
    public List<Challenge> findByDescription(String description);
}
