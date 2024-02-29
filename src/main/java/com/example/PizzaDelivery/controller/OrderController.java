package com.example.PizzaDelivery.controller;

import com.example.PizzaDelivery.exception.CartNotFoundException;
import com.example.PizzaDelivery.model.Cart;
import com.example.PizzaDelivery.model.CartItem;
import com.example.PizzaDelivery.model.Order;
import com.example.PizzaDelivery.service.CartItemService;
import com.example.PizzaDelivery.service.CartService;
import com.example.PizzaDelivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired private OrderService orderService;
    @Autowired private CartService cartService;

    @PostMapping("/add/{cartId}")
    public ResponseEntity<?> createOrder(@PathVariable Integer cartId){
        try{
            return ResponseEntity.ok(orderService.createNewOrder(cartId));
        }catch (CartNotFoundException e){
            return ResponseEntity.badRequest().body(new CartNotFoundException());
        }
    }

    @GetMapping("/totalPrice/{orderId}")
    public ResponseEntity<?> getTotalPrice(@PathVariable Long orderId){
        try{
            return ResponseEntity.ok().body(orderService.getTotalPrice(orderId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
