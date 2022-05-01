package com.felipesalles.mspartyhall.controller;

import java.net.URI;
import java.util.List;

import com.felipesalles.mspartyhall.entities.PartyHall;
import com.felipesalles.mspartyhall.service.PartyHallService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/party-halls")
public class PartyHallController {

    private PartyHallService partyHallService;
    
    @GetMapping
    public ResponseEntity<List<PartyHall>> getAllPartyHalls() {
        List<PartyHall> partyHalls = partyHallService.getAllPartyHalls();

        return ResponseEntity.ok(partyHalls);
    }

    @PostMapping
    public ResponseEntity<Void> createPartyHall(@RequestBody PartyHall partyHall) {
        PartyHall newPartyHall = partyHallService.createPartyHall(partyHall);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newPartyHall.getId()).toUri();
		return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PartyHall> getPartyHall(@PathVariable Long id) {

        return ResponseEntity.ok(partyHallService.getPartyHall(id));
    }
}
