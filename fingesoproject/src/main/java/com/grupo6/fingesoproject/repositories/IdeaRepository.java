package com.grupo6.fingesoproject.repositories;

import com.grupo6.fingesoproject.models.Idea;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IdeaRepository extends MongoRepository<Idea, String> {
    public Idea findIdeaById(String id);
    public Idea findByTitle(String title);
    public Idea findByDescriptionContains(String description);
    public List<Idea> findIdeaByOwner(String id);
    public List<Idea> findAllByOwner(String id);

}
