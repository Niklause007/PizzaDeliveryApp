package com.example.PizzaDelivery.service;

import com.example.PizzaDelivery.model.Address;
import com.example.PizzaDelivery.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address saveAddress(Address address){
        return addressRepository.save(address);
    }
}
