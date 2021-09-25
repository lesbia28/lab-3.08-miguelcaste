
package com.ironhack.lab3.e2.repository;

import com.ironhack.lab3.e2.model.Event;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EventRepositoryTest {

    @Autowired
    private EventRepository eventRepository;

    Event e1;

    @BeforeEach
    void setUp() throws ParseException {

        Date date = new Date(121,6,28);

        e1=new Event(date,180,"Madrid","Summer event");
        eventRepository.save(e1);
    }

    @AfterEach
    void tearDown() {
        eventRepository.deleteAll();
    }


    @Test
    void saveEvent_Event_created(){
        assertEquals(1,eventRepository.findAll().size());
        assertEquals("Summer event",eventRepository.findById(1L).get().getTitle());
    }


}