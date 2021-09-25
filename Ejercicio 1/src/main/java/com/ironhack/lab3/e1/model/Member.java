package com.ironhack.lab3.e1.model;


import com.ironhack.lab3.e1.enums.Status;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Member {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;

    private Date renewalDate;

    @OneToOne(mappedBy = "president")
    private Chapter chapterOfWhichIsPresident;

    public Member() {
    }

    public Member(String name, Status status, Date renewalDate) {
        this.name = name;
        this.status = status;
        this.renewalDate = renewalDate;
    }

    public Member(String name, Status status, Date renewalDate, Chapter chapterOfWhichIsPresident) {
        this.name = name;
        this.status = status;
        this.renewalDate = renewalDate;
        this.chapterOfWhichIsPresident = chapterOfWhichIsPresident;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(Date renewalDate) {
        this.renewalDate = renewalDate;
    }

    public Chapter getChapterOfWhichIsPresident() {
        return chapterOfWhichIsPresident;
    }

    public void setChapterOfWhichIsPresident(Chapter chapterOfWhichIsPresident) {
        this.chapterOfWhichIsPresident = chapterOfWhichIsPresident;
    }
}
