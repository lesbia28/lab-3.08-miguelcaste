package com.ironhack.lab3.e2.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.sql.Date;
import java.util.List;

@Entity
public class Conference extends Event{

    @ManyToMany
    @JoinTable(name ="conference_speakers",
            joinColumns = {@JoinColumn(name="conference_id")},
            inverseJoinColumns = {@JoinColumn(name="speakers_id")})
    private List<Speaker> speakers;

    public Conference() {
    }

    public Conference(Date date, int duration, String location, String title) {
        super(date, duration, location, title);
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }
//
}
