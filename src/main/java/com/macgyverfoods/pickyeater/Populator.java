package com.macgyverfoods.pickyeater;

import com.macgyverfoods.pickyeater.models.*;
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
    private ParentRepository parentRepo;

    @Resource
    private PreferenceRepository preferenceRepo;

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

        Preference butter2 = new Preference("Butter",dairy);
        Preference cheese2 = new Preference("Cheese",dairy);
        Preference cream2 = new Preference("Cream",dairy);
        Preference iceCream2 = new Preference("Ice Cream",dairy);
        Preference milk2 = new Preference("Milk",dairy);
        Preference yogurt2 = new Preference("Yogurt",dairy);
        preferenceRepo.save(butter2);
        preferenceRepo.save(cheese2);
        preferenceRepo.save(cream2);
        preferenceRepo.save(iceCream2);
        preferenceRepo.save(milk2);
        preferenceRepo.save(yogurt2);

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

        Preference apple2 = new Preference("Apple",fruits);
        Preference avocado2 = new Preference("Avocado",fruits);
        Preference banana2 = new Preference("Banana",fruits);
        Preference mango2 = new Preference("Mango",fruits);
        Preference pear2 = new Preference("Pear",fruits);
        Preference pineapple2 = new Preference("Pineapple",fruits);
        Preference orange2 = new Preference("Orange",fruits);
        Preference strawberry2 = new Preference("Strawberry",fruits);
        Preference tomato2 = new Preference("Tomato",fruits);
        Preference watermelon2 = new Preference("Watermelon",fruits);
        preferenceRepo.save(apple2);
        preferenceRepo.save(avocado2);
        preferenceRepo.save(banana2);
        preferenceRepo.save(mango2);
        preferenceRepo.save(pear2);
        preferenceRepo.save(pineapple2);
        preferenceRepo.save(orange2);
        preferenceRepo.save(strawberry2);
        preferenceRepo.save(tomato2);
        preferenceRepo.save(watermelon2);

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

        Preference bread2 = new Preference("Bread",grains);
        Preference cereal2 = new Preference("Cereal",grains);
        Preference corn2 = new Preference("Corn",grains);
        Preference pasta2 = new Preference("Pasta",grains);
        Preference oats2 = new Preference("Oats",grains);
        Preference rice2 = new Preference("Rice",grains);
        preferenceRepo.save(bread2);
        preferenceRepo.save(cereal2);
        preferenceRepo.save(corn2);
        preferenceRepo.save(pasta2);
        preferenceRepo.save(oats2);
        preferenceRepo.save(rice2);

        Ingredient beef = new Ingredient("Beef",protein);
        Ingredient chicken = new Ingredient("Chicken",protein);
        Ingredient eggs = new Ingredient("Eggs",protein);
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

        Preference beef2 = new Preference("Beef",protein);
        Preference chicken2 = new Preference("Chicken",protein);
        Preference eggs2 = new Preference("Eggs",protein);
        Preference fish2 = new Preference("Fish",protein);
        Preference lamb2 = new Preference("Lamb",protein);
        Preference shrimp2 = new Preference("Shrimp",protein);
        Preference turkey2 = new Preference("Turkey",protein);
        preferenceRepo.save(beef2);
        preferenceRepo.save(chicken2);
        preferenceRepo.save(eggs2);
        preferenceRepo.save(fish2);
        preferenceRepo.save(lamb2);
        preferenceRepo.save(shrimp2);
        preferenceRepo.save(turkey2);

        Ingredient broccoli = new Ingredient("Broccoli",vegetables);
        Ingredient capsicum = new Ingredient("Capsicum",vegetables);
        Ingredient carrot = new Ingredient("Carrot",vegetables);
        Ingredient lettuce = new Ingredient("Lettuce",vegetables);
        Ingredient mushroom = new Ingredient("Mushroom",vegetables);
        Ingredient potato = new Ingredient("Potato",vegetables);
        Ingredient onion = new Ingredient("Onion",vegetables);
        Ingredient zucchini = new Ingredient("Zucchini",vegetables);
        ingredientRepo.save(broccoli);
        ingredientRepo.save(carrot);
        ingredientRepo.save(capsicum);
        ingredientRepo.save(lettuce);
        ingredientRepo.save(mushroom);
        ingredientRepo.save(potato);
        ingredientRepo.save(onion);
        ingredientRepo.save(zucchini);

        Preference broccoli2 = new Preference("Broccoli",vegetables);
        Preference capsicum2 = new Preference("Capsicum",vegetables);
        Preference carrot2 = new Preference("Carrot",vegetables);
        Preference lettuce2 = new Preference("Lettuce",vegetables);
        Preference mushroom2 = new Preference("Mushroom",vegetables);
        Preference potato2 = new Preference("Potato",vegetables);
        Preference onion2 = new Preference("Onion",vegetables);
        Preference zucchini2 = new Preference("Zucchini",vegetables);
        preferenceRepo.save(broccoli2);
        preferenceRepo.save(carrot2);
        preferenceRepo.save(capsicum2);
        preferenceRepo.save(lettuce2);
        preferenceRepo.save(mushroom2);
        preferenceRepo.save(potato2);
        preferenceRepo.save(onion2);
        preferenceRepo.save(zucchini2);

        Allergy wheatAllergy = new Allergy("Wheat");
        Allergy eggsAllergy = new Allergy("Eggs");
        Allergy fishAllergy = new Allergy("Fish");
        Allergy sesameAllergy = new Allergy("Sesame");
        Allergy milkAllergy = new Allergy("Milk");
        Allergy peanutAllergy = new Allergy("Peanut");
        Allergy shellfishAllergy = new Allergy("Shellfish");
        Allergy soyAllergy = new Allergy("Soy");
        Allergy treeNutAllergy = new Allergy("Tree Nut");
        allergyRepo.save(wheatAllergy);
        allergyRepo.save(eggsAllergy);
        allergyRepo.save(fishAllergy);
        allergyRepo.save(sesameAllergy);
        allergyRepo.save(milkAllergy);
        allergyRepo.save(peanutAllergy);
        allergyRepo.save(shellfishAllergy);
        allergyRepo.save(soyAllergy);
        allergyRepo.save(treeNutAllergy);

        Parent johnDoe = new Parent("John", "Doe", "johnDoe@gmail.com");
        parentRepo.save(johnDoe);

        Child testChild = new Child("test","test","2");
        childRepo.save(testChild);

        johnDoe.addChild(testChild);
    }
}
