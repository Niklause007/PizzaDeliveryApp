package com.example.PizzaDelivery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Payment payment;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
}
