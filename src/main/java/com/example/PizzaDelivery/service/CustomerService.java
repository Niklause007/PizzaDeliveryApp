package com.example.PizzaDelivery.service;

import com.example.PizzaDelivery.model.Cart;
import com.example.PizzaDelivery.model.Customer;
import com.example.PizzaDelivery.model.LoginDTO;
import com.example.PizzaDelivery.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressService addressService;
    public Customer addNewCustomer(Customer customer) {
        Cart cart = customer.getCart();
        cart.setCustomer(customer);
        addressService.saveAddress(customer.getAddress());
        return customerRepository.save(customer);
    }
    public Customer loginUser(LoginDTO login) {
        return customerRepository.findCustomerByUsernameAndPassword(login.getUsername(), login.getPassword());
    }
    public Customer getCustomerById(int customerId) {
        return customerRepository.findCustomerByCustomerId(customerId);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
