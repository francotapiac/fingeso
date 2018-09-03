package com.grupo6.fingesoproject.models;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Document
public class Challenge {
    @Id
    private String id;
    private String title;
    private String description;
    private Date creationDate;
    private Date startDate;
    private Date endDate;

    @DBRef
    private Evaluator owner;

    //Constructor
    public Challenge(String title, String description, Date creationDate, Date startDate, Date endDate, Evaluator owner, List<Idea> suscribedIdeas, Idea winningIdea) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.owner = owner;
        this.suscribedIdeas = suscribedIdeas;
        this.winningIdea = winningIdea;
    }
    //Methods

    //Getter and setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Evaluator getOwner() {
        return owner;
    }

    public void setOwner(Evaluator owner) {
        this.owner = owner;
    }

    public List<Idea> getSuscribedIdeas() {
        return suscribedIdeas;
    }

    public void setSuscribedIdeas(List<Idea> suscribedIdeas) {
        this.suscribedIdeas = suscribedIdeas;
    }

    public Idea getWinningIdea() {
        return winningIdea;
    }

    public void setWinningIdea(Idea winningIdea) {
        this.winningIdea = winningIdea;
    }

    private List<Idea> suscribedIdeas;
    private Idea winningIdea;


    public Challenge() {
    }
}

