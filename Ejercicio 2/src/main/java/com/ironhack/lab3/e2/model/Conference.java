package com.ironhack.lab3.e2.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Conference extends Event{

    @ManyToMany
    @JoinTable(name ="conference_speakers",
            joinColumns = {@JoinColumn(name="conference_id")},
            inverseJoinColumns = {@JoinColumn(name="speakers_id")})
    private Set<Speaker> speakers = new HashSet<Speaker>();

    public Conference() {
    }

    public Conference(Date date, int duration, String location, String title) {
        super(date, duration, location, title);
    }

    public Conference(Date date, int duration, String location, String title, Set<Guest> guests) {
        super(date, duration, location, title, guests);
    }

    public Set<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Set<Speaker> speakers) {
        this.speakers = speakers;
    }

    public void addSpeakers(Speaker speaker){
        this.speakers.add(speaker);
    }

}
