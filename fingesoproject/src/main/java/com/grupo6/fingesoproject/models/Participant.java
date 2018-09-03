package com.grupo6.fingesoproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document
public class Participant {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;

    @JsonIgnore
    @DBRef
    private List<Idea> ideas;

    @JsonIgnore
    @DBRef
    private List<Rating> ratings;

    //Constructor
    public Participant(String name, String email, String password, List<Idea> ideas, List<Rating> ratings) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.ideas = ideas;
        this.ratings = ratings;
    }

    //Methods

    //Getter and setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Idea> getIdeas() {
        return ideas;
    }

    public void setIdeas(List<Idea> ideas) {
        this.ideas = ideas;
    }
}
