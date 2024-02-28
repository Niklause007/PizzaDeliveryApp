package com.example.PizzaDelivery.controller;

import com.example.PizzaDelivery.model.Customer;
import com.example.PizzaDelivery.model.LoginDTO;
import com.example.PizzaDelivery.model.RegisterDTO;
import com.example.PizzaDelivery.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public Customer addNewCustomer(@Valid @RequestBody RegisterDTO registerDTO) {
        Customer customer = new Customer(registerDTO);
        return customerService.addNewCustomer(customer);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO login) {
        Customer customer = customerService.loginUser(login);
        if(customer==null){
            return ResponseEntity.badRequest().body("Wrong Credentials");
        }
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getOrdersOfCustomer(@PathVariable Integer customerId){
        try {
            Customer customer = customerService.getCustomerById(customerId);
            return ResponseEntity.ok(customer.getOrders());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCustomers(){
        try{
            return ResponseEntity.ok(customerService.getAllCustomers());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
