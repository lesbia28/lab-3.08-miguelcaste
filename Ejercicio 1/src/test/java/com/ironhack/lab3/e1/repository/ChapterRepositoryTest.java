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

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ChapterRepositoryTest {
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
        Optional<Chapter> chapter1= chapterRepository.findById(1L);
        Optional<Chapter> chapter2=chapterRepository.findById(2L);
        assertEquals("Pediatría",chapter1.get().getName());
        assertEquals("Oncología",chapter2.get().getName());

        assertEquals("Miguel",chapter1.get().getPresident().getName());
        assertEquals("Antonio",chapter2.get().getPresident().getName());

    }

}