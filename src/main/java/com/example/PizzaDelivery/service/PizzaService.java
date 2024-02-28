package com.example.PizzaDelivery.service;

import com.example.PizzaDelivery.model.Category;
import com.example.PizzaDelivery.model.Pizza;
import com.example.PizzaDelivery.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private CategoryService categoryService;

    public Pizza savePizza(Pizza pizza){

        String categoryName = pizza.getCategory().getCategoryName().toUpperCase();
        Category category = categoryService.getCategoryByName(categoryName);

        if(category==null){
            Category newCategory = categoryService.saveCategory(pizza.getCategory());
            pizza.setCategory(newCategory);
        }else{
            pizza.setCategory(category);
        }

        return pizzaRepository.save(pizza);
    }
}
