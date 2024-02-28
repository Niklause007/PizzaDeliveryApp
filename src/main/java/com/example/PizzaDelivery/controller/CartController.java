package com.example.PizzaDelivery.controller;

import com.example.PizzaDelivery.model.CartItem;
import com.example.PizzaDelivery.model.CartItemsDTO;
import com.example.PizzaDelivery.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add/{userId}")
    public ResponseEntity<?> addItemToCart(@PathVariable Integer userId, @RequestBody CartItemsDTO cartItems){
        try{
            return ResponseEntity.ok(cartService.addItemsToCart(userId, cartItems));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
