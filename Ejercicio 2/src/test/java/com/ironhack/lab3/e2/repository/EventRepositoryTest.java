
package com.ironhack.lab3.e2.repository;

import com.ironhack.lab3.e2.enums.Status;
import com.ironhack.lab3.e2.model.Event;
import com.ironhack.lab3.e2.model.Guest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EventRepositoryTest {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private GuestRepository guestRepository;

    private Event e1;

    private Guest g1;

    @BeforeEach
    void setUp() {
        LocalDate date = LocalDate.of(2021, 6,28);

        g1=new Guest("Miguel", Status.ATTENDING);
        guestRepository.save(g1);

        e1=new Event(java.sql.Date.valueOf(date),180,"Madrid","Summer event");
        e1.addGuest(g1);
        eventRepository.save(e1);
    }

    @AfterEach
    void tearDown() {
        eventRepository.deleteAll();
        guestRepository.deleteAll();
    }


    @Test
    void saveEvent_Event_created(){
        Optional<Guest> guest1=guestRepository.findById(1L);
        assertEquals("Miguel",guest1.get().getName());

        assertEquals(1,eventRepository.findAll().size());
        assertEquals("Summer event",eventRepository.findById(1L).get().getTitle());
        assertEquals("2021-06-28",eventRepository.findById(1L).get().getDate().toString());
    }


}