package com.grupo6.fingesoproject.repositories;

import com.grupo6.fingesoproject.models.Idea;
import com.grupo6.fingesoproject.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    public User findUserById(String id);
    public User findUserByEmail(String email);
    public List<User> findAllByLastNameAndFirstNameAndEmail(String lastName, String firstName, String email);
    public List<User> findAllByLastNameOrFirstNameOrEmail(String lastName, String firstName, String email);
    public List<User> findAllByEmailOrFirstNameOrLastName(String email, String firstName, String lastName);
    public List<User> findAllByLastNameOrEmail(String lastName, String email);
    public List<User> findAllByFirstNameOrEmail(String firstName, String email);
    public List<User> findAllByFirstName(String firstName);
    public List<User> findAllByLastName(String lastName);
    public List<User> findAllByEmail(String email);
    public  List<User> findByLastNameOrFirstName(String lastName, String firstName);
}
