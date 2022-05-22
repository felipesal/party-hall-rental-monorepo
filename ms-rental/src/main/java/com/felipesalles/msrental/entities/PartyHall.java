package com.felipesalles.msrental.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PartyHall implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Integer capacity;
    private Double valuePerGuest;

}
