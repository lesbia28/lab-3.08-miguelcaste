package com.ironhack.lab3.e2.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private int duration;
    private String location;
    private String title;

    @ManyToMany (mappedBy = "events")
    private List<Guest> guests;


    public Event() {
    }

    public Event(Date date, int duration, String location, String title) {
        this.date = date;
        this.duration = duration;
        this.location = location;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }
}
