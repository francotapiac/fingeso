package com.grupo6.fingesoproject.repositories;

import com.grupo6.fingesoproject.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
    public User findUserById(String id);
    public User findUserByEmail(String email);
}
