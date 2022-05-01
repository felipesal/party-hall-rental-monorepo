package com.felipesalles.mspartyhall.repositories;

import com.felipesalles.mspartyhall.entities.PartyHall;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyHallRepository extends JpaRepository<PartyHall, Long> {
    
}
