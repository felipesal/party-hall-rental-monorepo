package com.felipesalles.msrental.repositories;

import com.felipesalles.msrental.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}