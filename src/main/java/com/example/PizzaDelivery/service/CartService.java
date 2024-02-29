package com.example.PizzaDelivery.service;

import com.example.PizzaDelivery.exception.UserNotFoundException;
import com.example.PizzaDelivery.model.*;
import com.example.PizzaDelivery.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired private CartRepository cartRepository;
    @Autowired private CustomerService customerService;
    @Autowired private CartItemService cartItemService;
    public Cart addItemsToCart(Integer userId, CartItemsDTO cartItems)throws UserNotFoundException {
        for(CartItem i: cartItems.getCartItems()){
            cartItemService.saveCartItem(i);
        }
        Customer customer = customerService.getCustomerById(userId);
        Cart cart = customer.getCart();
        if(cart==null){
            Cart newCart = new Cart();
            saveNewCart(newCart);
            customer.setCart(newCart);
            cart = newCart;
            customerService.updateCustomer(customer);
        }
        cart.setPizzas(cartItems.getCartItems());
        cartRepository.save(cart);
        return cart;
    }

    public Cart saveNewCart(Cart cart){
        return cartRepository.save(cart);
    }

    public Cart getCartByCartId(Integer cartId) {

        return cartRepository.getReferenceById(cartId);
    }

    public void deleteCart(Cart cart) {
        cartRepository.delete(cart);
    }
}
