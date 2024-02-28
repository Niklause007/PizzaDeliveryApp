package com.example.PizzaDelivery.service;

import com.example.PizzaDelivery.model.Category;
import com.example.PizzaDelivery.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveCategory(Category category){
        category.setCategoryName(category.getCategoryName().toUpperCase());
        return categoryRepository.save(category);
    }

    public Category getCategoryByName(String categoryName){
        System.out.println("getCategoryByName" + categoryRepository.findCategoryByCategoryName(categoryName));
        return categoryRepository.findCategoryByCategoryName(categoryName);
    }
}
