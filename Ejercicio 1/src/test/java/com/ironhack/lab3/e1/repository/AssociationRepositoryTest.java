package com.ironhack.lab3.e1.repository;

import com.ironhack.lab3.e1.model.Association;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AssociationRepositoryTest {

    @Autowired
    private AssociationRepository associationRepository;

    Association a1;


    @BeforeEach
    void setUp() {
        a1=new Association(1,"Madrid Association");
        associationRepository.save(a1);
    }

    @AfterEach
    void tearDown() {
        associationRepository.deleteAll();
    }

    @Test
    void findAll(){
        List<Association> l1=associationRepository.findAll();
        assertEquals("Madrid Association",l1.get(0).getName());
    }

    @Test
    void findById(){
        Optional<Association> a= associationRepository.findById(1);
        assertEquals("Madrid Association",a.get().getName());
    }

}