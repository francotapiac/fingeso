package com.grupo6.fingesoproject.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Evaluation {
    @Id
    private String id;
    private float value;
    private Date creationDate;

    private Participant owner;
    private Idea idea;

    public Evaluation(float value, Date creationDate, Participant owner, Idea idea) {
        this.value = value;
        this.creationDate = creationDate;
        this.owner = owner;
        this.idea = idea;
    }

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