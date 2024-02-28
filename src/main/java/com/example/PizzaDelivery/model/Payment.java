package com.example.PizzaDelivery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer paymentId;

    private  Boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    private  Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    private Order order;
}
