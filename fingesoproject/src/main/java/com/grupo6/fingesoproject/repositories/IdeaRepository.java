package com.grupo6.fingesoproject.repositories;

import com.grupo6.fingesoproject.models.Idea;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Dictionary;
import java.util.List;

public interface IdeaRepository extends MongoRepository<Idea, String> {
    public Idea findIdeaById(String id);
    public List<Idea> findByTitle(String title);
    public List<Idea> findByTitleLike(String title);
    public List<Idea> findByDescriptionLike(String description);
    public List<Idea> findIdeaByOwner(String id);
    public List findByOwner(String id);
    public List<Idea> findByDescription(String description);
}
