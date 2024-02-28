package com.example.PizzaDelivery.service;

import com.example.PizzaDelivery.model.CartItem;
import com.example.PizzaDelivery.model.Category;
import com.example.PizzaDelivery.model.Pizza;
import com.example.PizzaDelivery.repository.CartItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepo cartItemRepo;
    @Autowired
    private PizzaService pizzaService;

    public void saveCartItem(CartItem i) {
        System.out.println("SAVING CART ITEM and PIZZA....");

        Category category = i.getPizza().getCategory();
        category.setCategoryName(category.getCategoryName().toUpperCase());

        Pizza pizza = new Pizza();
        pizza.setPizzaName(i.getPizza().getPizzaName());
        pizza.setCategory(category);
        pizza.setPrice(i.getPizza().getPrice());

        cartItemRepo.save(i);

        pizzaService.savePizza(pizza);
    }
}
