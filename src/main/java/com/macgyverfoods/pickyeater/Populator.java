package com.macgyverfoods.pickyeater;

import com.macgyverfoods.pickyeater.models.*;
import com.macgyverfoods.pickyeater.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;

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

        Ingredient almondMilk = new Ingredient("Almond Milk");
        Ingredient butter = new Ingredient("Butter");
        Ingredient cheese = new Ingredient("Cheese");
        Ingredient coconutMilk = new Ingredient("Coconut Milk");
        Ingredient cream = new Ingredient("Cream");
        Ingredient goatCheese = new Ingredient("Goat Cheese");
        Ingredient iceCream = new Ingredient("Ice Cream");
        Ingredient milk = new Ingredient("Milk");
        Ingredient riceMilk = new Ingredient("Rice Milk");
        Ingredient sourCream = new Ingredient("Sour Cream");
        Ingredient soyMilk = new Ingredient("Soy Milk");
        Ingredient yogurt = new Ingredient("Yogurt");
        ingredientRepo.save(almondMilk);
        ingredientRepo.save(butter);
        ingredientRepo.save(cheese);
        ingredientRepo.save(coconutMilk);
        ingredientRepo.save(cream);
        ingredientRepo.save(goatCheese);
        ingredientRepo.save(iceCream);
        ingredientRepo.save(milk);
        ingredientRepo.save(riceMilk);
        ingredientRepo.save(sourCream);
        ingredientRepo.save(soyMilk);
        ingredientRepo.save(yogurt);

        Ingredient apple = new Ingredient("Apple");
        Ingredient avocado = new Ingredient("Avocado");
        Ingredient banana = new Ingredient("Banana");
        Ingredient blackberry = new Ingredient("Blackberry");
        Ingredient blueberry = new Ingredient("Blueberry");
        Ingredient clementine = new Ingredient("Clementine");
        Ingredient coconut = new Ingredient("Coconut");
        Ingredient cranberry = new Ingredient("Cranberry");
        Ingredient grapefruit = new Ingredient("Grapefruit");
        Ingredient honeydew = new Ingredient("Honeydew");
        Ingredient lemon = new Ingredient("Lemon");
        Ingredient lime = new Ingredient("Lime");
        Ingredient mango = new Ingredient("Mango");
        Ingredient orange = new Ingredient("Orange");
        Ingredient peach = new Ingredient("Peach");
        Ingredient pear = new Ingredient("Pear");
        Ingredient pineapple = new Ingredient("Pineapple");
        Ingredient raisin = new Ingredient("Raisin");
        Ingredient raspberry = new Ingredient("Raspberry");
        Ingredient strawberry = new Ingredient("Strawberry");
        Ingredient tomato = new Ingredient("Tomato");
        Ingredient watermelon = new Ingredient("Watermelon");
        ingredientRepo.save(apple);
        ingredientRepo.save(avocado);
        ingredientRepo.save(banana);
        ingredientRepo.save(blackberry);
        ingredientRepo.save(blueberry);
        ingredientRepo.save(clementine);
        ingredientRepo.save(coconut);
        ingredientRepo.save(cranberry);
        ingredientRepo.save(grapefruit);
        ingredientRepo.save(honeydew);
        ingredientRepo.save(lemon);
        ingredientRepo.save(lime);
        ingredientRepo.save(mango);
        ingredientRepo.save(orange);
        ingredientRepo.save(peach);
        ingredientRepo.save(pear);
        ingredientRepo.save(pineapple);
        ingredientRepo.save(raisin);
        ingredientRepo.save(raspberry);
        ingredientRepo.save(strawberry);
        ingredientRepo.save(tomato);
        ingredientRepo.save(watermelon);

        Ingredient bread = new Ingredient("Bread");
        Ingredient cereal = new Ingredient("Cereal");
        Ingredient corn = new Ingredient("Corn");
        Ingredient eggNoodle = new Ingredient("Egg Noodle");
        Ingredient flourTortilla = new Ingredient("Flour Tortilla");
        Ingredient oats = new Ingredient("Oats");
        Ingredient pasta = new Ingredient("Pasta");
        Ingredient pizzaCrust = new Ingredient("Pizza Crust");
        Ingredient ramenNoodle = new Ingredient("Ramen Noodle");
        Ingredient rice = new Ingredient("Rice");
        Ingredient riceNoodle = new Ingredient("Rice Noodle");
        Ingredient tacoShell = new Ingredient("Taco Shell");
        ingredientRepo.save(bread);
        ingredientRepo.save(cereal);
        ingredientRepo.save(corn);
        ingredientRepo.save(eggNoodle);
        ingredientRepo.save(flourTortilla);
        ingredientRepo.save(oats);
        ingredientRepo.save(pasta);
        ingredientRepo.save(pizzaCrust);
        ingredientRepo.save(ramenNoodle);
        ingredientRepo.save(rice);
        ingredientRepo.save(riceNoodle);
        ingredientRepo.save(tacoShell);

        Ingredient bacon = new Ingredient("Bacon");
        Ingredient beef = new Ingredient("Beef");
        Ingredient chicken = new Ingredient("Chicken");
        Ingredient chickenBreast = new Ingredient("Chicken Breast");
        Ingredient cod = new Ingredient("cod");
        Ingredient crab = new Ingredient("Crab");
        Ingredient eggs = new Ingredient("Eggs");
        Ingredient fish = new Ingredient("Fish");
        Ingredient ham = new Ingredient("Ham");
        Ingredient lamb = new Ingredient("Lamb");
        Ingredient lobster = new Ingredient("Lobster");
        Ingredient porkShoulder = new Ingredient("Pork Shoulder");
        Ingredient porkTenderloin = new Ingredient("Pork Tenderloin");
        Ingredient shrimp = new Ingredient("Shrimp");
        Ingredient turkey = new Ingredient("Turkey");
        ingredientRepo.save(bacon);
        ingredientRepo.save(beef);
        ingredientRepo.save(chicken);
        ingredientRepo.save(chickenBreast);
        ingredientRepo.save(cod);
        ingredientRepo.save(crab);
        ingredientRepo.save(eggs);
        ingredientRepo.save(fish);
        ingredientRepo.save(ham);
        ingredientRepo.save(lamb);
        ingredientRepo.save(lobster);
        ingredientRepo.save(porkShoulder);
        ingredientRepo.save(porkTenderloin);
        ingredientRepo.save(shrimp);
        ingredientRepo.save(turkey);

        Ingredient broccoli = new Ingredient("Broccoli");
        Ingredient capsicum = new Ingredient("Capsicum");
        Ingredient carrot = new Ingredient("Carrot");
        Ingredient lettuce = new Ingredient("Lettuce");
        Ingredient mushroom = new Ingredient("Mushroom");
        Ingredient potato = new Ingredient("Potato");
        Ingredient onion = new Ingredient("Onion");
        Ingredient zucchini = new Ingredient("Zucchini");
        ingredientRepo.save(broccoli);
        ingredientRepo.save(carrot);
        ingredientRepo.save(capsicum);
        ingredientRepo.save(lettuce);
        ingredientRepo.save(mushroom);
        ingredientRepo.save(potato);
        ingredientRepo.save(onion);
        ingredientRepo.save(zucchini);

        FoodCategory dairy = new FoodCategory("Dairy","/dairy.jpg",
                almondMilk, butter, cheese, coconutMilk, cream, goatCheese, iceCream, milk, riceMilk, sourCream, soyMilk, yogurt);
        FoodCategory fruits = new FoodCategory("Fruits","/fruit_.jpg",
                apple, avocado, banana, blackberry, blueberry, clementine, coconut, cranberry, grapefruit, honeydew, lemon, lime, mango, orange, peach, pear, pineapple, raisin, raspberry, strawberry, tomato, watermelon);
        FoodCategory grains = new FoodCategory("Grains","/grains.jpg",
                bread, cereal, corn, flourTortilla, eggNoodle, oats, pasta, pizzaCrust, ramenNoodle, rice, riceNoodle, tacoShell);
        FoodCategory protein = new FoodCategory("Proteins","/protein.png",
                bacon, beef, chicken, chickenBreast, cod, crab, eggs, fish, ham, lamb, lobster, porkShoulder, porkTenderloin, shrimp, turkey);
        FoodCategory vegetables = new FoodCategory("Vegetables","/vegetables.jpg",
                broccoli, carrot, capsicum, lettuce, mushroom, potato, onion, zucchini);
        foodCategoryRepo.save(dairy);
        foodCategoryRepo.save(fruits);
        foodCategoryRepo.save(grains);
        foodCategoryRepo.save(protein);
        foodCategoryRepo.save(vegetables);

        Preference almondMilk2 = new Preference("Almond Milk", dairy);
        Preference butter2 = new Preference("Butter",dairy);
        Preference cheese2 = new Preference("Cheese",dairy);
        Preference coconutMilk2 = new Preference("Coconut Milk", dairy);
        Preference cream2 = new Preference("Cream",dairy);
        Preference goatCheese2 = new Preference("Goat Cheese", dairy);
        Preference iceCream2 = new Preference("Ice Cream",dairy);
        Preference milk2 = new Preference("Milk",dairy);
        Preference riceMilk2 = new Preference("Rice Milk", dairy);
        Preference sourCream2 = new Preference("Sour Cream", dairy);
        Preference soyMilk2 = new Preference("Soy Milk", dairy);
        Preference yogurt2 = new Preference("Yogurt",dairy);
        preferenceRepo.save(almondMilk2);
        preferenceRepo.save(butter2);
        preferenceRepo.save(cheese2);
        preferenceRepo.save(coconutMilk2);
        preferenceRepo.save(cream2);
        preferenceRepo.save(goatCheese2);
        preferenceRepo.save(iceCream2);
        preferenceRepo.save(milk2);
        preferenceRepo.save(riceMilk2);
        preferenceRepo.save(sourCream2);
        preferenceRepo.save(soyMilk2);
        preferenceRepo.save(yogurt2);

        Preference apple2 = new Preference("Apple",fruits);
        Preference avocado2 = new Preference("Avocado",fruits);
        Preference banana2 = new Preference("Banana",fruits);
        Preference blackberry2 = new Preference("Blackberry", fruits);
        Preference blueberry2 = new Preference("Blueberry", fruits);
        Preference clementine2 = new Preference("Clementine", fruits);
        Preference coconut2 = new Preference("Coconut", fruits);
        Preference cranberry2 = new Preference("Cranberry", fruits);
        Preference grapefruit2 = new Preference("Grapefruit", fruits);
        Preference honeydew2 = new Preference("Honeydew", fruits);
        Preference lemon2 = new Preference("Lemon", fruits);
        Preference lime2 = new Preference("Lime", fruits);
        Preference mango2 = new Preference("Mango",fruits);
        Preference orange2 = new Preference("Orange",fruits);
        Preference peach2 = new Preference("Peach", fruits);
        Preference pear2 = new Preference("Pear",fruits);
        Preference pineapple2 = new Preference("Pineapple",fruits);
        Preference raisin2 = new Preference("Raisin", fruits);
        Preference raspberry2 = new Preference("Raspberry", fruits);
        Preference strawberry2 = new Preference("Strawberry",fruits);
        Preference tomato2 = new Preference("Tomato",fruits);
        Preference watermelon2 = new Preference("Watermelon",fruits);
        preferenceRepo.save(apple2);
        preferenceRepo.save(avocado2);
        preferenceRepo.save(banana2);
        preferenceRepo.save(blackberry2);
        preferenceRepo.save(blueberry2);
        preferenceRepo.save(clementine2);
        preferenceRepo.save(coconut2);
        preferenceRepo.save(cranberry2);
        preferenceRepo.save(grapefruit2);
        preferenceRepo.save(honeydew2);
        preferenceRepo.save(lemon2);
        preferenceRepo.save(lime2);
        preferenceRepo.save(mango2);
        preferenceRepo.save(orange2);
        preferenceRepo.save(peach2);
        preferenceRepo.save(pear2);
        preferenceRepo.save(pineapple2);
        preferenceRepo.save(raisin2);
        preferenceRepo.save(raspberry2);
        preferenceRepo.save(strawberry2);
        preferenceRepo.save(tomato2);
        preferenceRepo.save(watermelon2);

        Preference bread2 = new Preference("Bread",grains);
        Preference cereal2 = new Preference("Cereal",grains);
        Preference corn2 = new Preference("Corn",grains);
        Preference eggNoodle2 = new Preference("Egg Noodle", grains);
        Preference flourTortilla2 = new Preference("Flour Tortilla", grains);
        Preference oats2 = new Preference("Oats",grains);
        Preference pasta2 = new Preference("Pasta",grains);
        Preference pizzaCrust2 = new Preference("Pizza Crust", grains);
        Preference ramenNoodle2 = new Preference("Ramen Noodle", grains);
        Preference rice2 = new Preference("Rice",grains);
        Preference riceNoodle2 = new Preference("Rice Noodle", grains);
        Preference tacoShell2 = new Preference("Taco Shell", grains);
        preferenceRepo.save(bread2);
        preferenceRepo.save(cereal2);
        preferenceRepo.save(corn2);
        preferenceRepo.save(eggNoodle2);
        preferenceRepo.save(flourTortilla2);
        preferenceRepo.save(oats2);
        preferenceRepo.save(pasta2);
        preferenceRepo.save(pizzaCrust2);
        preferenceRepo.save(ramenNoodle2);
        preferenceRepo.save(rice2);
        preferenceRepo.save(riceNoodle2);
        preferenceRepo.save(tacoShell2);

        Preference bacon2 = new Preference("Bacon", protein);
        Preference beef2 = new Preference("Beef",protein);
        Preference chicken2 = new Preference("Chicken",protein);
        Preference chickenBreast2 = new Preference("Chicken Breast", protein);
        Preference cod2 = new Preference("Cod", protein);
        Preference crab2 = new Preference("Crab", protein);
        Preference eggs2 = new Preference("Eggs",protein);
        Preference fish2 = new Preference("Fish",protein);
        Preference ham2 = new Preference("Ham", protein);
        Preference lamb2 = new Preference("Lamb",protein);
        Preference lobster2 = new Preference("Lobster", protein);
        Preference porkShoulder2 = new Preference("Pork Shoulder", protein);
        Preference porkTenderloin2 = new Preference("Pork Tenderloin", protein);
        Preference shrimp2 = new Preference("Shrimp",protein);
        Preference turkey2 = new Preference("Turkey",protein);
        preferenceRepo.save(bacon2);
        preferenceRepo.save(beef2);
        preferenceRepo.save(chicken2);
        preferenceRepo.save(chickenBreast2);
        preferenceRepo.save(cod2);
        preferenceRepo.save(crab2);
        preferenceRepo.save(eggs2);
        preferenceRepo.save(fish2);
        preferenceRepo.save(ham2);
        preferenceRepo.save(lamb2);
        preferenceRepo.save(lobster2);
        preferenceRepo.save(porkShoulder2);
        preferenceRepo.save(porkTenderloin2);
        preferenceRepo.save(shrimp2);
        preferenceRepo.save(turkey2);

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
        johnDoe.addIngredient(broccoli);
        parentRepo.save(johnDoe);

        Child testChild = new Child("test","test","2",johnDoe);
        Child testChild2 = new Child("tdssfsdfsd","testfsdfdsf","22",johnDoe);
        testChild.addAllergy(wheatAllergy);
        testChild2.addAllergy(wheatAllergy);
        childRepo.save(testChild);
        childRepo.save(testChild2);

    }
}
