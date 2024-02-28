package com.example.PizzaDelivery.controller;

import com.example.PizzaDelivery.model.Pizza;
import com.example.PizzaDelivery.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping("")
    public ResponseEntity<?> addPizza(@RequestBody Pizza pizza){
        try{
            return ResponseEntity.ok().body(pizzaService.savePizza(pizza));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
