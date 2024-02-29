package com.example.PizzaDelivery.service;

import com.example.PizzaDelivery.exception.UserNotFoundException;
import com.example.PizzaDelivery.model.*;
import com.example.PizzaDelivery.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired private CustomerRepository customerRepository;
    @Autowired private AddressService addressService;
    public Customer addNewCustomer(Customer customer) {
        addressService.saveAddress(customer.getAddress());
        return customerRepository.save(customer);
    }
    public Customer loginUser(LoginDTO login) {
        return customerRepository.findCustomerByUsernameAndPassword(login.getUsername(), login.getPassword());
    }
    public Customer getCustomerById(int customerId)throws UserNotFoundException {
        return customerRepository.findCustomerByCustomerId(customerId);
    }
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer findCustomerByCart(Cart cart){
        return customerRepository.findCustomerByCart(cart);
    }

    public List<Order> getAllOrders(Long customerId) {
        return customerRepository.findCustomerByCustomerId(customerId).getOrders();
    }

    public Cart getCartByCustomerId(Long customerId) {
        return customerRepository.findCustomerByCustomerId(customerId).getCart();
    }

    public List<Payment> getPayments(Long customerId) {
        return customerRepository.findCustomerByCustomerId(customerId).getPaymentList();
    }
}
