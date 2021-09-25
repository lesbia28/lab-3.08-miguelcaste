package com.ironhack.lab3.e2.repository;

import com.ironhack.lab3.e2.model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker,Long> {

}
