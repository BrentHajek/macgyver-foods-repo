package com.macgyverfoods.pickyeater;

import com.macgyverfoods.pickyeater.models.FoodCategory;
import com.macgyverfoods.pickyeater.models.Ingredient;
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

        Ingredient butter = new Ingredient("Butter",dairy);
        Ingredient cheese = new Ingredient("Cheese",dairy);
        Ingredient cream = new Ingredient("Cream",dairy);
        Ingredient iceCream = new Ingredient("Ice Cream",dairy);
        Ingredient milk = new Ingredient("Milk",dairy);
        Ingredient yogurt = new Ingredient("Yogurt",dairy);
        ingredientRepo.save(butter);
        ingredientRepo.save(cheese);
        ingredientRepo.save(cream);
        ingredientRepo.save(iceCream);
        ingredientRepo.save(milk);
        ingredientRepo.save(yogurt);

        Ingredient apple = new Ingredient("Apple",fruits);
        Ingredient avocado = new Ingredient("Avocado",fruits);
        Ingredient banana = new Ingredient("Banana",fruits);
        Ingredient mango = new Ingredient("Mango",fruits);
        Ingredient pear = new Ingredient("Pear",fruits);
        Ingredient pineapple = new Ingredient("Pineapple",fruits);
        Ingredient orange = new Ingredient("Orange",fruits);
        Ingredient strawberry = new Ingredient("Strawberry",fruits);
        Ingredient tomato = new Ingredient("Tomato",fruits);
        Ingredient watermelon = new Ingredient("Watermelon",fruits);
        ingredientRepo.save(apple);
        ingredientRepo.save(avocado);
        ingredientRepo.save(banana);
        ingredientRepo.save(mango);
        ingredientRepo.save(pear);
        ingredientRepo.save(pineapple);
        ingredientRepo.save(orange);
        ingredientRepo.save(strawberry);
        ingredientRepo.save(tomato);
        ingredientRepo.save(watermelon);

        Ingredient bread = new Ingredient("Bread",grains);
        Ingredient cereal = new Ingredient("Cereal",grains);
        Ingredient corn = new Ingredient("Corn",grains);
        Ingredient pasta = new Ingredient("Pasta",grains);
        Ingredient oats = new Ingredient("Oats",grains);
        Ingredient rice = new Ingredient("Rice",grains);
        ingredientRepo.save(bread);
        ingredientRepo.save(cereal);
        ingredientRepo.save(corn);
        ingredientRepo.save(pasta);
        ingredientRepo.save(oats);
        ingredientRepo.save(rice);

        Ingredient beef = new Ingredient("Beef",protein);
        Ingredient chicken = new Ingredient("Chicken",protein);
        Ingredient eggs = new Ingredient("Beef",protein);
        Ingredient fish = new Ingredient("Fish",protein);
        Ingredient lamb = new Ingredient("Lamb",protein);
        Ingredient shrimp = new Ingredient("Shrimp",protein);
        Ingredient turkey = new Ingredient("Turkey",protein);
        ingredientRepo.save(beef);
        ingredientRepo.save(chicken);
        ingredientRepo.save(eggs);
        ingredientRepo.save(fish);
        ingredientRepo.save(lamb);
        ingredientRepo.save(shrimp);
        ingredientRepo.save(turkey);

    }
}
