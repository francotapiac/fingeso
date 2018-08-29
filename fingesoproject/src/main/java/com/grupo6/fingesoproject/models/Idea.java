package com.grupo6.fingesoproject.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
public class Idea {
    @Id
    private String id;
    private String description;
    private Date creationDate;

    private Participant owner;
    private List<Evaluation> evaluations;
    private List<Commentary> commentaries;
    private List<Challenge> challenges;

    public Idea(String description, Date creationDate, Participant owner, List<Evaluation> evaluations, List<Commentary> commentaries, List<Challenge> challenges) {
        this.description = description;
        this.creationDate = creationDate;
        this.owner = owner;
        this.evaluations = evaluations;
        this.commentaries = commentaries;
        this.challenges = challenges;
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

    public Participant getOwner() {
        return owner;
    }

    public void setOwner(Participant owner) {
        this.owner = owner;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public List<Commentary> getCommentaries() {
        return commentaries;
    }

    public void setCommentaries(List<Commentary> commentaries) {
        this.commentaries = commentaries;
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }


}
