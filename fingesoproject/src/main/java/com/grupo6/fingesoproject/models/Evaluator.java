package com.grupo6.fingesoproject.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Evaluator extends Participant{
    @Id
    private String id;

    public Evaluator(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
