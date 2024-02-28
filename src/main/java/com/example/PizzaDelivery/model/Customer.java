package com.example.PizzaDelivery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;

    @NotEmpty(message = "Please give customer name ")
    private String customerName;

    @NotBlank(message = "Username cannot be blank")
    @Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    @Email(message = "Please provide a valid email address")
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$",
            message = "Please provide a valid email address")
    private String customerEmail;

    @NotNull(message = "Customer mobile number cannot be null")
//    @Pattern(regexp = "^\\d{10}$", message = "Please provide a valid 10-digit mobile number")
    private Long customerMobile;

//    @NotEmpty(message = "Please give customer Address ")
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Cart cart;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Payment> paymentList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders;

    public Customer(RegisterDTO registerDTO){
        customerName = registerDTO.getCustomerName();
        username = registerDTO.getUsername();
        password = registerDTO.getPassword();
        customerEmail = registerDTO.getCustomerEmail();
        customerMobile = registerDTO.getCustomerMobile();
        address = registerDTO.getAddress();
        cart = new Cart();
        paymentList = null;
        orders = null;
    }

}
