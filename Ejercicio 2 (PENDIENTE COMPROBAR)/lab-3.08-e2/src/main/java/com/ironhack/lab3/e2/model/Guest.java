package com.ironhack.lab3.e2.model;

import com.ironhack.lab3.e2.enums.Status;

import javax.persistence.*;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany
    @JoinTable(
            name="guest_events",
            joinColumns = {@JoinColumn (name="guest_id")},
            inverseJoinColumns = {@JoinColumn(name="event_id")})
    private List<Event> events;

    public Guest() {
    }

    public Guest(String name, Status status, List<Event> events) {
        this.name = name;
        this.status = status;
        this.events = events;
    }

    public Guest(String name, Status status) {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
