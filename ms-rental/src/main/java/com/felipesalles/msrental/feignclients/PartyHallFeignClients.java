package com.felipesalles.msrental.feignclients;

import java.util.List;

import com.felipesalles.msrental.entities.PartyHall;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "ms-party-hall", url = "localhost:8001", path = "/party-halls")
public interface PartyHallFeignClients {
    
    @GetMapping
    public ResponseEntity<List<PartyHall>> getAllPartyHalls();

    @GetMapping(value = "/{id}")
    public ResponseEntity<PartyHall> getPartyHall(@PathVariable Long id);
}
