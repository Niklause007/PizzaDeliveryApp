package com.example.PizzaDelivery.repository;

import com.example.PizzaDelivery.model.Cart;
import com.example.PizzaDelivery.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
