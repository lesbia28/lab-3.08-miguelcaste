package com.ironhack.lab3.e2.model;

import com.ironhack.lab3.e2.enums.Status;

import javax.persistence.Entity;

@Entity
public class Speaker extends Guest {
    private int presentationDuration;

    public Speaker() {
        super();

    }

    public Speaker(String name, Status status, int presentationDuration) {
        super(name,status);
        this.presentationDuration = presentationDuration;
    }

    public int getPresentationDuration() {
        return presentationDuration;
    }

    public void setPresentationDuration(int presentationDuration) {
        this.presentationDuration = presentationDuration;
    }
}
