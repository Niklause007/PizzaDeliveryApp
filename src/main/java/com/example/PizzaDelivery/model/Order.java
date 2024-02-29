package com.example.PizzaDelivery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @OneToMany
    private List<CartItem> orderedItems;

    @ManyToOne
    @JsonIgnore
    private Customer customer;

    @OneToOne
    @JsonIgnore
    private Payment payment;
}
