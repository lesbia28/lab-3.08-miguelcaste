package com.ironhack.lab3.e1.repository;

import com.ironhack.lab3.e1.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
}
