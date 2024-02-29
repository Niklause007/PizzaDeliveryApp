package com.example.PizzaDelivery.controller;

import com.example.PizzaDelivery.exception.PizzaNotFoundException;
import com.example.PizzaDelivery.model.Pizza;
import com.example.PizzaDelivery.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping("/add")
    public ResponseEntity<?> addPizza(@RequestBody Pizza pizza){
        try{
            return ResponseEntity.ok().body(pizzaService.savePizza(pizza));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{pizzaId}")
    public ResponseEntity<?> updatePizza(@PathVariable Long pizzaId, @RequestBody Pizza pizza){
        try{
            return ResponseEntity.ok().body(pizzaService.updatePizza(pizzaId,pizza));
        }catch (PizzaNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
