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

    @OneToMany
    private List<CartItem> pizzas;

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", pizzas=" + pizzas +
                '}';
    }
}
