package com.ironhack.lab3.e2.model;

import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class Exposition extends Event{
    public Exposition() {
    }

    public Exposition(Date date, int duration, String location, String title) {
        super(date, duration, location, title);
    }


}
