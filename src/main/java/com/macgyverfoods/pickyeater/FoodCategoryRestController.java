package com.macgyverfoods.pickyeater;

import com.macgyverfoods.pickyeater.models.FoodCategory;
import com.macgyverfoods.pickyeater.repositories.FoodCategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
public class FoodCategoryRestController {

    @Resource
    FoodCategoryRepository foodCategoryRepo;

    @GetMapping("/api/foodCategories")
    public Collection<FoodCategory> getFoodCategories() {
        return (Collection<FoodCategory>) foodCategoryRepo.findAll();
    }

    @GetMapping("/api/foodCategories/{foodCategoryId}")
        public FoodCategory getFoodCategory(@PathVariable Long foodCategoryId) {
            return foodCategoryRepo.findById(foodCategoryId).get();
        }
}
