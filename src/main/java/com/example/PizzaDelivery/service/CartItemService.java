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
    @Autowired
    private CategoryService categoryService;

    public void saveCartItem(CartItem i) {
        Pizza pizza = i.getPizza();
        Category category = i.getPizza().getCategory();
        String categoryName = category.getCategoryName().toUpperCase();
        Category category1 = categoryService.getCategoryByName(categoryName);
        if(category1 == null){
            Category newCategory = categoryService.saveCategory(category);
            pizza.setCategory(newCategory);
        }
        pizzaService.savePizza(pizza);
        cartItemRepo.save(i);
    }
}
