package com.example.PizzaDelivery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    @NotEmpty(message = "Please give customer name ")
    private String customerName;

    @NotBlank(message = "Username cannot be blank")
    @Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    @Email(message = "Please provide a valid email address")
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$",
            message = "Please provide a valid email address")
    @Column(unique = true)
    private String customerEmail;

    @NotNull(message = "Customer mobile number cannot be null")
    @Column(unique = true)
    private Long customerMobile;

    @OneToOne
    private Address address;

    @OneToOne
    private Cart cart;

    @OneToMany
    private List<Payment> paymentList;

    @OneToMany
    private List<Order> orders;

    public Customer(RegisterDTO registerDTO){
        customerName = registerDTO.getCustomerName();
        username = registerDTO.getUsername();
        password = registerDTO.getPassword();
        customerEmail = registerDTO.getCustomerEmail();
        customerMobile = registerDTO.getCustomerMobile();
        address = registerDTO.getAddress();
        cart = null;
        paymentList = null;
        orders = null;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerMobile=" + customerMobile +
                ", address=" + address +
                ", cart=" + cart +
                ", paymentList=" + paymentList +
                ", orders=" + orders +
                '}';
    }
}
