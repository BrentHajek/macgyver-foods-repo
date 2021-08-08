package com.macgyverfoods.pickyeater.rest.controllers;

import com.macgyverfoods.pickyeater.models.FoodCategory;
import com.macgyverfoods.pickyeater.repositories.FoodCategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Optional;

@RestController
public class FoodCategoryRestController {

    @Resource
    FoodCategoryRepository foodCategoryRepo;

    @GetMapping("/foodCategories")
    public Collection<FoodCategory> getFoodCategories() {
        return (Collection<FoodCategory>) foodCategoryRepo.findAll();
    }

    @GetMapping("/foodCategories/{id}")
        public Optional<FoodCategory> getFoodCategory(@PathVariable Long id) {
            return foodCategoryRepo.findById(id);
        }
}
