package com.ironhack.lab3.e2.model;

import javax.persistence.Entity;
import java.sql.Date;
import java.util.Set;

@Entity
public class Exposition extends Event{
    public Exposition() {
        super();
    }

    public Exposition(Date date, int duration, String location, String title) {
        super(date, duration, location, title);
    }

    public Exposition(Date date, int duration, String location, String title, Set<Guest> list) {
        super(date, duration, location, title, list);
    }
}
