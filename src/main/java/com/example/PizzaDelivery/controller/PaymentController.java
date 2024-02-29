package com.example.PizzaDelivery.controller;

import com.example.PizzaDelivery.exception.PaymentFailedException;
import com.example.PizzaDelivery.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired private PaymentService paymentService;

    @GetMapping("/updateStatus/{orderId}")
    public ResponseEntity<?> updatePaymentStatus(@PathVariable Long orderId){
        try{
            return ResponseEntity.ok().body(paymentService.updatePaymentStatus(orderId));
        }catch (PaymentFailedException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/status/{orderId}")
    public ResponseEntity<?> getPaymentStatus(@PathVariable Long orderId){
        try{
            return ResponseEntity.ok().body(paymentService.getPaymentStatus(orderId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
