package com.ironhack.lab3.e1.repository;

import com.ironhack.lab3.e1.enums.Status;
import com.ironhack.lab3.e1.model.Association;
import com.ironhack.lab3.e1.model.Chapter;
import com.ironhack.lab3.e1.model.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    private AssociationRepository associationRepository;

    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired
    private MemberRepository memberRepository;

    Association a1;
    Chapter c1;
    Chapter c2;
    Member m1;
    Member m2;


    @BeforeEach
    void setUp() {
        a1=new Association(1,"Madrid Association");
        associationRepository.save(a1);

        LocalDate date= LocalDate.now();

        m1=new Member("Miguel", Status.ACTIVE, java.sql.Date.valueOf(date));
        m2=new Member("Antonio",Status.ACTIVE,java.sql.Date.valueOf(date));

        memberRepository.save(m1);
        memberRepository.save(m2);

        c1=new Chapter("Pediatría",2,a1);
        c2=new Chapter("Oncología",2,a1);

        c1.setPresident(m1);
        c2.setPresident(m2);

        chapterRepository.save(c1);
        chapterRepository.save(c2);

    }

    @AfterEach
    void tearDown() {
        chapterRepository.deleteAll();
        memberRepository.deleteAll();
        associationRepository.deleteAll();
    }

    @Test
    void findById(){
        Optional<Member> member1= memberRepository.findById(1L);
        Optional<Member> member2=memberRepository.findById(2L);
        assertEquals("Miguel",member1.get().getName());
        assertEquals("Antonio",member2.get().getName());
    }

}