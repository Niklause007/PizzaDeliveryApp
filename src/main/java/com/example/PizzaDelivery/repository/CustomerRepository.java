package com.example.PizzaDelivery.repository;

import com.example.PizzaDelivery.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByUsernameAndPassword(String username, String password);
    Customer findCustomerByCustomerId(int customerId);
}
