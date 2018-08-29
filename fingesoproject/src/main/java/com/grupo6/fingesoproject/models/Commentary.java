package com.grupo6.fingesoproject.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Commentary {
    @Id
    private String id;
    private String text;

    private Participant owner;
    private Idea idea;

    public Commentary(String text, Participant owner, Idea idea) {
        this.text = text;
        this.owner = owner;
        this.idea = idea;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
