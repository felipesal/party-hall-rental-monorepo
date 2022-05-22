package com.felipesalles.msrental.service;

import java.util.List;

// import com.felipesalles.msrental.Order;
import com.felipesalles.msrental.entities.PartyHall;
import com.felipesalles.msrental.entities.DTO.OrderDTO;
import com.felipesalles.msrental.feignclients.PartyHallFeignClients;
// import com.felipesalles.msrental.producer.OrderProducer;
import com.felipesalles.msrental.repositories.OrderRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class RentalPartyHallService {
    
    private PartyHallFeignClients partyHallFeignClients;

    private OrderRepository orderRepository;

    // private OrderProducer orderProducer;

    public List<PartyHall> getAllPartyHalls() {
        List<PartyHall> partyHalls = partyHallFeignClients.getAllPartyHalls().getBody();

        return partyHalls;
    }

    public PartyHall getPartyHall(Long id) {
        return partyHallFeignClients.getPartyHall(id).getBody();
    }

    public void createOrder(OrderDTO orderDto) {
        PartyHall partyHall = getPartyHall(orderDto.getPartyHallId());
        Double totalValue = calculatePartyValue(partyHall.getValuePerGuest(), orderDto.getQtGuests());
        orderDto.setTotalValue(totalValue);
        var newOrder =  orderRepository.save(orderDto.fromDtoToOrder());
        orderDto.setId(newOrder.getId());
        // sendMessage(orderDto);
    }

    // private void sendMessage(OrderDTO orderDTO) {
    //     var message = Order.newBuilder()
    //                     .setId(orderDTO.getId())
    //                     .setPartyHallId(orderDTO.getPartyHallId())
    //                     // .setDate(orderDTO.getDate().toString())
    //                     .setQtGuests(orderDTO.getQtGuests())
    //                     .setTotalValue(orderDTO.getTotalValue())
    //                     .build();
    //     log.info("Order: " + message);
    //     orderProducer.sendMessage(message);
    // }

    private Double calculatePartyValue(Double valuePerGuest, Integer qtGuests) {
        return valuePerGuest * qtGuests;
    }

}
