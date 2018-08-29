package com.grupo6.fingesoproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Evaluator extends Participant{
    @Id
    private String id;

    @JsonIgnore
    @DBRef
    private List<Challenge> challenges;


    //Constructor
    public Evaluator(String name, String email, String password, List<Idea> ideas, List<Challenge> challenges) {
        super(name, email, password, ideas);
        this.challenges = challenges;
    }

    //Methods

    //Getter and setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
