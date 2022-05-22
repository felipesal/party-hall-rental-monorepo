package com.felipesalles.msrental.controller;

import java.net.URI;
import java.util.List;

import com.felipesalles.msrental.entities.Order;
import com.felipesalles.msrental.entities.PartyHall;
import com.felipesalles.msrental.entities.DTO.OrderDTO;
import com.felipesalles.msrental.service.RentalPartyHallService;

import org.springframework.http.HttpStatus;
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
@RequestMapping(value = "/orders")
@AllArgsConstructor
public class OrderController {
    
    private RentalPartyHallService rentalPartyHallService;

    @GetMapping(value = "/party-halls")
    public ResponseEntity<List<PartyHall>> getAllPartyHalls() {
        List<PartyHall> partyHalls = rentalPartyHallService.getAllPartyHalls();

        return ResponseEntity.ok(partyHalls);
    }

    @GetMapping(value = "/party-halls/{id}")
    public ResponseEntity<PartyHall> getPartyHall(@PathVariable Long id) {
        PartyHall partyHall = rentalPartyHallService.getPartyHall(id);

        return ResponseEntity.ok(partyHall);
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderDTO orderDto) {
        rentalPartyHallService.createOrder(orderDto);

		return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
