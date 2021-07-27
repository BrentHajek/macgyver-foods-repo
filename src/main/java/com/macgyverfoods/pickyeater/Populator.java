package com.macgyverfoods.pickyeater;

import com.macgyverfoods.pickyeater.models.FoodCategory;
import com.macgyverfoods.pickyeater.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private AllergyRepository allergyRepo;

    @Resource
    private ChildRepository childRepo;

    @Resource
    private FoodCategoryRepository foodCategoryRepo;

    @Resource
    private IngredientRepository ingredientRepo;

    @Resource
    private ParentRepository parentRepository;

    @Resource
    private PreferenceRepository preferenceRepo;

    @Resource
    private SubChildRepository subChildRepo;

    @Override
    public void run(String... args) throws Exception {

        FoodCategory dairy = new FoodCategory("Dairy","/dairy.jpg");
        FoodCategory fruits = new FoodCategory("Fruits","/fruit_.jpg");
        FoodCategory grains = new FoodCategory("Grains","/grains.jpg");
        FoodCategory protein = new FoodCategory("Proteins","/protein.png");
        FoodCategory vegetables = new FoodCategory("Vegetables","/vegetables.jpg");
        foodCategoryRepo.save(dairy);
        foodCategoryRepo.save(fruits);
        foodCategoryRepo.save(grains);
        foodCategoryRepo.save(protein);
        foodCategoryRepo.save(vegetables);

        


    }
}
