package com.grupo6.fingesoproject.models;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document
public class Rating {
    @Id
    private String id;
    private float value;
    private Date creationDate;

    @DBRef
    private Participant owner;
    @DBRef
    private Idea idea;

    //Constructor
    public Rating(float value, Date creationDate, Participant owner, Idea idea) {
        this.value = value;
        this.creationDate = creationDate;
        this.owner = owner;
        this.idea = idea;
    }

    //Methods

    //Getter and setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Participant getOwner() {
        return owner;
    }

    public void setOwner(Participant owner) {
        this.owner = owner;
    }

    public Idea getIdea() {
        return idea;
    }

    public void setIdea(Idea idea) {
        this.idea = idea;
    }
}
