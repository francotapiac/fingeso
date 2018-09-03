package com.grupo6.fingesoproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.annotation.Id; //este
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Document
public class Idea {
    @Id
    private String id;
    private String description;
    private Date creationDate;

    @DBRef
    private Participant owner;
    @JsonIgnore
    @DBRef
    private List<Rating> ratings;
    @JsonIgnore
    @DBRef
    private List<Commentary> commentaries;
    @JsonIgnore
    @DBRef
    private List<Challenge> challenges;

    public Idea(String description, Date creationDate, Participant owner, List<Rating> ratings, List<Commentary> commentaries, List<Challenge> challenges) {
        this.description = description;
        this.creationDate = creationDate;
        this.owner = owner;
        this.ratings = ratings;
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

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
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
