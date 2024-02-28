package com.example.PizzaDelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    private String customerName;
    private String username;
    private String password;
    private String customerEmail;
    private Long customerMobile;
    private Address address;
}
