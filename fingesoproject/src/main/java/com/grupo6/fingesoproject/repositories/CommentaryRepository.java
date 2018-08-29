package com.grupo6.fingesoproject.repositories;

import com.grupo6.fingesoproject.models.Commentary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentaryRepository extends MongoRepository<Commentary, Long> {
    public Commentary findCommentaryById(String id);
}
