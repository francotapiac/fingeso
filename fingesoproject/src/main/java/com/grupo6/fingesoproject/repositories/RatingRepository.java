package com.grupo6.fingesoproject.repositories;

import com.grupo6.fingesoproject.models.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepository extends MongoRepository<Rating, String> {
    public User findRatingById(String id);
    public User findRatingByValue(float value);
}
