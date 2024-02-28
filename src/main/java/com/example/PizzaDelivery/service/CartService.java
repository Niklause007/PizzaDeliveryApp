package com.example.PizzaDelivery.service;

import com.example.PizzaDelivery.model.*;
import com.example.PizzaDelivery.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CartItemService cartItemService;

    public Cart addItemsToCart(Integer userId, CartItemsDTO cartItems) {
        Customer customer = customerService.getCustomerById(userId);
        Cart cart = customer.getCart();
        cart.setPizzas(cartItems.getCartItems());

        for(CartItem i: cartItems.getCartItems()){
            cartItemService.saveCartItem(i);
        }

        Cart cart1 = cartRepository.save(cart);
        customer.setCart(cart1);
        customerService.updateCustomer(customer);
        return cart1;
    }
}
