package com.felipesalles.msrental.entities.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.felipesalles.msrental.entities.Order;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDTO {
    
    private Long id;
    private Long partyHallId;
    private Integer qtGuests;
    private Double totalValue;
    // @JsonFormat(pattern = "dd/MM/yyyy")
	// private Date date;

    public Order fromDtoToOrder() {
        var newOrder = new Order();
        newOrder.setPartyHallId(getPartyHallId());
        newOrder.setQtGuests(getQtGuests());
        newOrder.setTotalValue(getTotalValue());
        // newOrder.setDate(getDate());

        return newOrder;
    }

}
