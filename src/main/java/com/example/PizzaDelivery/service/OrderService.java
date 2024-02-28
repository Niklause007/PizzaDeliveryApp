package com.example.PizzaDelivery.service;

import com.example.PizzaDelivery.model.Order;
import com.example.PizzaDelivery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
}
