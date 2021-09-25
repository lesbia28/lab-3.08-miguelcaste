package com.ironhack.lab3.e1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Association {
    @Id
    private int id;
    private String name;

    public Association() {
    }

    public Association(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
