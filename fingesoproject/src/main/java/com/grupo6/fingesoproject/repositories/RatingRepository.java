package com.grupo6.fingesoproject.repositories;

import com.grupo6.fingesoproject.models.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {
    public Rating findRatingById(String id);
    public List<Rating> findRatingByValue(float value);
}
