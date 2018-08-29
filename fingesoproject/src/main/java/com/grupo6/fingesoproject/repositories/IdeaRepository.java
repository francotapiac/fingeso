package com.grupo6.fingesoproject.repositories;

import com.grupo6.fingesoproject.models.Idea;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IdeaRepository extends MongoRepository<Idea, Long> {
    public Idea findIdeaById(String id);
}
