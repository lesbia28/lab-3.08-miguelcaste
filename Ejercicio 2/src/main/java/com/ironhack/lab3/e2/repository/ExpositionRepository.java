package com.ironhack.lab3.e2.repository;

import com.ironhack.lab3.e2.model.Exposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpositionRepository extends JpaRepository<Exposition,Long> {
}
