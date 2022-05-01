package com.felipesalles.mspartyhall.service;

import java.util.List;

import com.felipesalles.mspartyhall.entities.PartyHall;
import com.felipesalles.mspartyhall.repositories.PartyHallRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PartyHallService {
    
    private PartyHallRepository partyHallRepository;

    public List<PartyHall> getAllPartyHalls() {
        return partyHallRepository.findAll();
    }

    public PartyHall createPartyHall(PartyHall partyHall) {
        return partyHallRepository.save(partyHall);
    }

    public PartyHall getPartyHall(Long id) {
        return partyHallRepository.findById(id).get();
    }
}
