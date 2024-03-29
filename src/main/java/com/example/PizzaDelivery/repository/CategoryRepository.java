package com.example.PizzaDelivery.repository;

import com.example.PizzaDelivery.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT c FROM Category c WHERE c.categoryName = ?1")
    Category findCategoryByCategoryName(String categoryName);
}
