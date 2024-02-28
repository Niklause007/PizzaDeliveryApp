package com.example.PizzaDelivery.repository;

import com.example.PizzaDelivery.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
