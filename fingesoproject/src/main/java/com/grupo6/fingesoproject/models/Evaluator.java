package com.grupo6.fingesoproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

//@Document
public class Evaluator{
    @Id
    private String id;

    @JsonIgnore
    @DBRef
    private List<Challenge> challenges;

    //Constructor
    /*public Evaluator(String name, String email, String password, List<Idea> ideas, List<Rating> ratings, List<Challenge> challenges) {
        //super(name, email, password, ideas, ratings);
        this.challenges = challenges;
    }*/

    //Methods

    //Getter and setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
