package com.ironhack.lab3.e1.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Chapter { // DISTRITO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int district;

    @OneToOne
    @JoinColumn(name="president_id")
    private Member president;

    @ManyToOne
    @JoinColumn(name = "association_id")
    private Association association;

    // @OneToMany(mappedBy = "id")
    // private List<Member> members;

    @ManyToMany
    @JoinTable(name = "chapter_members",
                joinColumns = {@JoinColumn (name = "chapter_id")},
                inverseJoinColumns = {@JoinColumn(name = "member_id")})
    private Set<Member> set = new HashSet<Member>();

    public Chapter() {
    }


    public Chapter(String name, int district, Association association) {
        this.name = name;
        this.district = district;
        this.association = association;
    }

    public Chapter(String name, int district, Member president, Association association) {
        this.name = name;
        this.district = district;
        this.president = president;
        this.association = association;
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

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public Member getPresident() {
        return president;
    }

    public void setPresident(Member president) {
        this.president = president;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    public Set<Member> getSet() {
        return set;
    }

    public void setSet(Set<Member> set) {
        this.set = set;
    }
}
