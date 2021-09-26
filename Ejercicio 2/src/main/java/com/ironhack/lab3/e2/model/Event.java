package com.ironhack.lab3.e2.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private int duration;
    private String location;
    private String title;

    @ManyToMany
    @JoinTable(name = "events_guests",
            joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "guest_id")})
    private Set<Guest> list = new HashSet<Guest>();


    public Event() {
    }

    public Event(Date date, int duration, String location, String title) {
        this.date = date;
        this.duration = duration;
        this.location = location;
        this.title = title;
    }

    public Event(Date date, int duration, String location, String title, Set<Guest> list) {
        this.date = date;
        this.duration = duration;
        this.location = location;
        this.title = title;
        this.list = list;
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

    public Set<Guest> getList() {
        return list;
    }

    public void setList(Set<Guest> list) {
        this.list = list;
    }

    public void addGuest(Guest guest){
        this.list.add(guest);
    }

}
