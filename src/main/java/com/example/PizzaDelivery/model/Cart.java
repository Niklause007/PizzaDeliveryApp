package com.example.PizzaDelivery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> pizzas;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;
}
