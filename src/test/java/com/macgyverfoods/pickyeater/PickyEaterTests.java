package com.macgyverfoods.pickyeater;

import com.macgyverfoods.pickyeater.models.*;
import com.macgyverfoods.pickyeater.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PickyEaterTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private IngredientRepository ingredientRepo;

    @Autowired
    private AllergyRepository allergyRepo;

    @Autowired
    private PreferenceRepository preferenceRepo;

    @Autowired
    private ChildRepository childRepo;

    @Autowired
    private ParentRepository parentRepo;

    @Autowired
    private FoodCategoryRepository foodCategoryRepo;

    @Test
    public void shouldSaveAndLoadPreferencesChild(){

        FoodCategory testFoodCategory = new FoodCategory("Dairy","dairy.jpg");
        FoodCategory testFoodCategory2 = new FoodCategory("Meat","meat.jpg");
        foodCategoryRepo.save(testFoodCategory);
        foodCategoryRepo.save(testFoodCategory2);

        Ingredient testIngredient = new Ingredient("milk1",testFoodCategory);
        Ingredient testIngredient2 = new Ingredient("Milk2",testFoodCategory);
        Ingredient testIngredient3 = new Ingredient("fish",testFoodCategory2);
        Ingredient testIngredient4 = new Ingredient("chicken",testFoodCategory2);
        ingredientRepo.save(testIngredient);
        ingredientRepo.save(testIngredient2);
        ingredientRepo.save(testIngredient3);
        ingredientRepo.save(testIngredient4);

        Preference testPreference = new Preference(testIngredient);
        Preference testPreference2 = new Preference(testIngredient2);
        Preference testPreference3 = new Preference(testIngredient3);
        Preference testPreference4 = new Preference(testIngredient4);
        preferenceRepo.save(testPreference);
        preferenceRepo.save(testPreference2);
        preferenceRepo.save(testPreference3);
        preferenceRepo.save(testPreference4);

        Allergy testAllergy = new Allergy("Lactose Tolerant");
        Allergy testAllergy2 = new Allergy("Peanut Allergy");
        Allergy testAllergy3 = new Allergy("Pollen");
        Allergy testAllergy4 = new Allergy("Fur");
        allergyRepo.save(testAllergy);
        allergyRepo.save(testAllergy2);
        allergyRepo.save(testAllergy3);
        allergyRepo.save(testAllergy4);

        Child testChild = new Child("1","2","3",testAllergy,testAllergy3);
        Child testChild2 = new Child("1","2","3",testAllergy4,testAllergy3);
        Child testChild3 = new Child("1","2","3",testAllergy2);
        childRepo.save(testChild);
        childRepo.save(testChild2);
        childRepo.save(testChild3);

        testChild.addPreference(testPreference);
        testChild.addPreference(testPreference2);
        testChild.addPreference(testPreference3);
        testChild2.addPreference(testPreference);
        testChild2.addPreference(testPreference2);
        testChild3.addPreference(testPreference4);

        entityManager.flush();
        entityManager.clear();

        Child retrievedChild = childRepo.findById(testChild.getId()).get();
        Preference testPreferenceR1 = preferenceRepo.findById(testPreference.getId()).get();
        Preference testPreferenceR2 = preferenceRepo.findById(testPreference2.getId()).get();
        Preference testPreferenceR3 = preferenceRepo.findById(testPreference3.getId()).get();
        assertThat(retrievedChild.getPreferences()).contains(testPreference,testPreference2,testPreference3);

    }

    @Test
    public void shouldSaveAndLoadChildrenToAParents(){

        FoodCategory testFoodCategory = new FoodCategory("Dairy","dairy.jpg");
        FoodCategory testFoodCategory2 = new FoodCategory("Meat","meat.jpg");
        foodCategoryRepo.save(testFoodCategory);
        foodCategoryRepo.save(testFoodCategory2);

        Ingredient testIngredient = new Ingredient("milk1",testFoodCategory);
        Ingredient testIngredient2 = new Ingredient("Milk2",testFoodCategory);
        Ingredient testIngredient3 = new Ingredient("fish",testFoodCategory2);
        Ingredient testIngredient4 = new Ingredient("chicken",testFoodCategory2);
        ingredientRepo.save(testIngredient);
        ingredientRepo.save(testIngredient2);
        ingredientRepo.save(testIngredient3);
        ingredientRepo.save(testIngredient4);

        Preference testPreference = new Preference(testIngredient);
        Preference testPreference2 = new Preference(testIngredient2);
        Preference testPreference3 = new Preference(testIngredient3);
        Preference testPreference4 = new Preference(testIngredient4);
        preferenceRepo.save(testPreference);
        preferenceRepo.save(testPreference2);
        preferenceRepo.save(testPreference3);
        preferenceRepo.save(testPreference4);

        Allergy testAllergy = new Allergy("Lactose Tolerant");
        Allergy testAllergy2 = new Allergy("Peanut Allergy");
        Allergy testAllergy3 = new Allergy("Pollen");
        Allergy testAllergy4 = new Allergy("Fur");
        allergyRepo.save(testAllergy);
        allergyRepo.save(testAllergy2);
        allergyRepo.save(testAllergy3);
        allergyRepo.save(testAllergy4);

        Child testChild = new Child("1","2","3",testAllergy,testAllergy3);
        Child testChild2 = new Child("1","2","3",testAllergy4,testAllergy3);
        Child testChild3 = new Child("1","2","3",testAllergy2);
        childRepo.save(testChild);
        childRepo.save(testChild2);
        childRepo.save(testChild3);

        testChild.addPreference(testPreference);
        testChild.addPreference(testPreference2);
        testChild.addPreference(testPreference3);
        testChild2.addPreference(testPreference);
        testChild2.addPreference(testPreference2);
        testChild3.addPreference(testPreference4);

        Parent testParent1 = new Parent("John","Doe","JohnDoe18@gmail.com");
        Parent testParent2 = new Parent("Test","Subject","TestSubject@gmail.com");
        parentRepo.save(testParent1);
        parentRepo.save(testParent2);

        testParent1.addChild(testChild);
        testParent1.addChild(testChild2);
        testParent2.addChild(testChild3);

        entityManager.flush();
        entityManager.clear();

        Parent retrievedParent1 = parentRepo.findById(testParent1.getId()).get();
        Child retrievedChild1 = childRepo.findById(testChild.getId()).get();
        Child retrievedChild2 = childRepo.findById(testChild2.getId()).get();
        assertThat(retrievedParent1.getChild()).contains(testChild,testChild2);
        Parent retrievedParent2 = parentRepo.findById(testParent2.getId()).get();
        Child retrievedChild3 = childRepo.findById(testChild3.getId()).get();
        assertThat(retrievedParent2.getChild()).contains(testChild3);
    }

    @Test
    public void shouldBeAbleToAddChildrenToAParent(){

        FoodCategory testFoodCategory = new FoodCategory("Dairy","dairy.jpg");
        FoodCategory testFoodCategory2 = new FoodCategory("Meat","meat.jpg");
        foodCategoryRepo.save(testFoodCategory);
        foodCategoryRepo.save(testFoodCategory2);

        Ingredient testIngredient = new Ingredient("milk1",testFoodCategory);
        Ingredient testIngredient2 = new Ingredient("Milk2",testFoodCategory);
        Ingredient testIngredient3 = new Ingredient("fish",testFoodCategory2);
        Ingredient testIngredient4 = new Ingredient("chicken",testFoodCategory2);
        ingredientRepo.save(testIngredient);
        ingredientRepo.save(testIngredient2);
        ingredientRepo.save(testIngredient3);
        ingredientRepo.save(testIngredient4);

        Preference testPreference = new Preference(testIngredient);
        Preference testPreference2 = new Preference(testIngredient2);
        Preference testPreference3 = new Preference(testIngredient3);
        Preference testPreference4 = new Preference(testIngredient4);
        preferenceRepo.save(testPreference);
        preferenceRepo.save(testPreference2);
        preferenceRepo.save(testPreference3);
        preferenceRepo.save(testPreference4);

        Allergy testAllergy = new Allergy("Lactose Tolerant");
        Allergy testAllergy2 = new Allergy("Peanut Allergy");
        Allergy testAllergy3 = new Allergy("Pollen");
        Allergy testAllergy4 = new Allergy("Fur");
        allergyRepo.save(testAllergy);
        allergyRepo.save(testAllergy2);
        allergyRepo.save(testAllergy3);
        allergyRepo.save(testAllergy4);

        Child testChild = new Child("1","2","3",testAllergy,testAllergy3);
        Child testChild2 = new Child("1","2","3",testAllergy4,testAllergy3);
        Child testChild3 = new Child("1","2","3",testAllergy2);
        Child testChild4 = new Child("1","2","3",testAllergy2);
        Child testChild5 = new Child("1","2","3",testAllergy2);
        childRepo.save(testChild);
        childRepo.save(testChild2);
        childRepo.save(testChild3);
        childRepo.save(testChild4);
        childRepo.save(testChild5);

        testChild.addPreference(testPreference);
        testChild.addPreference(testPreference2);
        testChild.addPreference(testPreference3);
        testChild2.addPreference(testPreference);
        testChild2.addPreference(testPreference2);
        testChild3.addPreference(testPreference4);
        testChild4.addPreference(testPreference);
        testChild4.addPreference(testPreference2);
        testChild4.addPreference(testPreference3);
        testChild4.addPreference(testPreference4);
        testChild5.addPreference(testPreference);

        Parent testParent1 = new Parent("John","Doe","JohnDoe18@gmail.com");
//        ,testIngredient,testIngredient2
        Parent testParent2 = new Parent("Test","Subject","TestSubject@gmail.com");
//        ,testIngredient3,testIngredient4
        parentRepo.save(testParent1);
        parentRepo.save(testParent2);

        testParent1.addChild(testChild);
        testParent1.addChild(testChild2);
        testParent1.addChild(testChild5);
        testParent2.addChild(testChild3);
        testParent2.addChild(testChild4);


        entityManager.flush();
        entityManager.clear();

        Parent retrievedParent1 = parentRepo.findById(testParent1.getId()).get();
        Parent retrievedParent2 = parentRepo.findById(testParent2.getId()).get();
        Child retrievedChild1 = childRepo.findById(testChild.getId()).get();
        Child retrievedChild2 = childRepo.findById(testChild2.getId()).get();
        Child retrievedChild3 = childRepo.findById(testChild3.getId()).get();
        Child retrievedChild4 = childRepo.findById(testChild4.getId()).get();
        Child retrievedChild5 = childRepo.findById(testChild5.getId()).get();
        assertThat(retrievedParent1.getChild()).contains(testChild,testChild2,testChild5);
        assertThat(retrievedParent2.getChild()).contains(testChild3,testChild4);

    }

    @Test
    public void shouldBeAbleToRemoveChildFromParent(){

        FoodCategory testFoodCategory = new FoodCategory("Dairy","dairy.jpg");
        FoodCategory testFoodCategory2 = new FoodCategory("Meat","meat.jpg");
        foodCategoryRepo.save(testFoodCategory);
        foodCategoryRepo.save(testFoodCategory2);

        Ingredient testIngredient = new Ingredient("milk1",testFoodCategory);
        Ingredient testIngredient2 = new Ingredient("Milk2",testFoodCategory);
        Ingredient testIngredient3 = new Ingredient("fish",testFoodCategory2);
        Ingredient testIngredient4 = new Ingredient("chicken",testFoodCategory2);
        ingredientRepo.save(testIngredient);
        ingredientRepo.save(testIngredient2);
        ingredientRepo.save(testIngredient3);
        ingredientRepo.save(testIngredient4);

        Preference testPreference = new Preference(testIngredient);
        Preference testPreference2 = new Preference(testIngredient2);
        Preference testPreference3 = new Preference(testIngredient3);
        Preference testPreference4 = new Preference(testIngredient4);
        preferenceRepo.save(testPreference);
        preferenceRepo.save(testPreference2);
        preferenceRepo.save(testPreference3);
        preferenceRepo.save(testPreference4);

        Allergy testAllergy = new Allergy("Lactose Tolerant");
        Allergy testAllergy2 = new Allergy("Peanut Allergy");
        Allergy testAllergy3 = new Allergy("Pollen");
        Allergy testAllergy4 = new Allergy("Fur");
        allergyRepo.save(testAllergy);
        allergyRepo.save(testAllergy2);
        allergyRepo.save(testAllergy3);
        allergyRepo.save(testAllergy4);

        Child testChild = new Child("1","2","3",testAllergy,testAllergy3);
        Child testChild2 = new Child("1","2","3",testAllergy4,testAllergy3);
        Child testChild3 = new Child("1","2","3",testAllergy2);
        Child testChild4 = new Child("1","2","3",testAllergy2);
        Child testChild5 = new Child("1","2","3",testAllergy2);
        childRepo.save(testChild);
        childRepo.save(testChild2);
        childRepo.save(testChild3);
        childRepo.save(testChild4);
        childRepo.save(testChild5);

        testChild.addPreference(testPreference);
        testChild.addPreference(testPreference2);
        testChild.addPreference(testPreference3);
        testChild2.addPreference(testPreference);
        testChild2.addPreference(testPreference2);
        testChild3.addPreference(testPreference4);
        testChild4.addPreference(testPreference);
        testChild4.addPreference(testPreference2);
        testChild4.addPreference(testPreference3);
        testChild4.addPreference(testPreference4);
        testChild5.addPreference(testPreference);

        Parent testParent1 = new Parent("John","Doe","JohnDoe18@gmail.com");
        Parent testParent2 = new Parent("Test","Subject","TestSubject@gmail.com");
        parentRepo.save(testParent1);
        parentRepo.save(testParent2);

        testParent1.addChild(testChild);
        testParent1.addChild(testChild2);
        testParent1.addChild(testChild5);
        testParent2.addChild(testChild3);
        testParent2.addChild(testChild4);

        testParent2.removeChild(testChild5);


        entityManager.flush();
        entityManager.clear();

        Parent retrievedParent1 = parentRepo.findById(testParent1.getId()).get();
        Parent retrievedParent2 = parentRepo.findById(testParent2.getId()).get();
        Child retrievedChild1 = childRepo.findById(testChild.getId()).get();
        Child retrievedChild2 = childRepo.findById(testChild2.getId()).get();
        Child retrievedChild3 = childRepo.findById(testChild3.getId()).get();
        Child retrievedChild4 = childRepo.findById(testChild4.getId()).get();
        Child retrievedChild5 = childRepo.findById(testChild5.getId()).get();
        assertThat(retrievedParent1.getChild()).contains(testChild,testChild2);
        assertThat(retrievedParent2.getChild()).contains(testChild3,testChild4);
    }

    @Test
    public void shouldAddIngredientToParent() {

        FoodCategory testFoodCategory = new FoodCategory("Dairy","dairy.jpg");
        FoodCategory testFoodCategory2 = new FoodCategory("Meat","meat.jpg");
        foodCategoryRepo.save(testFoodCategory);
        foodCategoryRepo.save(testFoodCategory2);

        Ingredient testIngredient = new Ingredient("milk1",testFoodCategory);
        Ingredient testIngredient2 = new Ingredient("Milk2",testFoodCategory);
        Ingredient testIngredient3 = new Ingredient("fish",testFoodCategory2);
        Ingredient testIngredient4 = new Ingredient("chicken",testFoodCategory2);
        ingredientRepo.save(testIngredient);
        ingredientRepo.save(testIngredient2);
        ingredientRepo.save(testIngredient3);
        ingredientRepo.save(testIngredient4);

        Preference testPreference = new Preference(testIngredient);
        Preference testPreference2 = new Preference(testIngredient2);
        Preference testPreference3 = new Preference(testIngredient3);
        Preference testPreference4 = new Preference(testIngredient4);
        preferenceRepo.save(testPreference);
        preferenceRepo.save(testPreference2);
        preferenceRepo.save(testPreference3);
        preferenceRepo.save(testPreference4);

        Allergy testAllergy = new Allergy("Lactose Tolerant");
        Allergy testAllergy2 = new Allergy("Peanut Allergy");
        Allergy testAllergy3 = new Allergy("Pollen");
        Allergy testAllergy4 = new Allergy("Fur");
        allergyRepo.save(testAllergy);
        allergyRepo.save(testAllergy2);
        allergyRepo.save(testAllergy3);
        allergyRepo.save(testAllergy4);

        Child testChild = new Child("1","2","3",testAllergy,testAllergy3);
        Child testChild2 = new Child("1","2","3",testAllergy4,testAllergy3);
        Child testChild3 = new Child("1","2","3",testAllergy2);
        Child testChild4 = new Child("1","2","3",testAllergy2);
        Child testChild5 = new Child("1","2","3",testAllergy2);
        childRepo.save(testChild);
        childRepo.save(testChild2);
        childRepo.save(testChild3);
        childRepo.save(testChild4);
        childRepo.save(testChild5);

        testChild.addPreference(testPreference);
        testChild.addPreference(testPreference2);
        testChild.addPreference(testPreference3);
        testChild2.addPreference(testPreference);
        testChild2.addPreference(testPreference2);
        testChild3.addPreference(testPreference4);
        testChild4.addPreference(testPreference);
        testChild4.addPreference(testPreference2);
        testChild4.addPreference(testPreference3);
        testChild4.addPreference(testPreference4);
        testChild5.addPreference(testPreference);

        Parent testParent1 = new Parent("John","Doe","JohnDoe18@gmail.com");
        Parent testParent2 = new Parent("Test","Subject","TestSubject@gmail.com");
        parentRepo.save(testParent1);
        parentRepo.save(testParent2);

        testParent1.addChild(testChild);
        testParent1.addChild(testChild2);
        testParent1.addChild(testChild5);
        testParent2.addChild(testChild3);
        testParent2.addChild(testChild4);

        testParent2.removeChild(testChild5);

        testParent1.addIngredient(testIngredient);
        testParent1.addIngredient(testIngredient2);
        testParent2.addIngredient(testIngredient3);
        testParent2.addIngredient(testIngredient4);

        entityManager.flush();
        entityManager.clear();

        Parent retrievedParent1 = parentRepo.findById(testParent1.getId()).get();
        Parent retrievedParent2 = parentRepo.findById(testParent2.getId()).get();
        Ingredient retrievedIngredient1 = ingredientRepo.findById(testIngredient.getId()).get();
        Ingredient retrievedIngredient2 = ingredientRepo.findById(testIngredient2.getId()).get();
        Ingredient retrievedIngredient3 = ingredientRepo.findById(testIngredient3.getId()).get();
        Ingredient retrievedIngredient4 = ingredientRepo.findById(testIngredient4.getId()).get();
        assertThat(retrievedParent1.getIngredients()).contains(testIngredient,testIngredient2);
        assertThat(retrievedParent2.getIngredients()).contains(testIngredient3,testIngredient4);
    }

    @Test
    public void shouldRemoveIngredientFromParent() {

        FoodCategory testFoodCategory = new FoodCategory("Dairy","dairy.jpg");
        FoodCategory testFoodCategory2 = new FoodCategory("Meat","meat.jpg");
        foodCategoryRepo.save(testFoodCategory);
        foodCategoryRepo.save(testFoodCategory2);

        Ingredient testIngredient = new Ingredient("milk1",testFoodCategory);
        Ingredient testIngredient2 = new Ingredient("Milk2",testFoodCategory);
        Ingredient testIngredient3 = new Ingredient("fish",testFoodCategory2);
        Ingredient testIngredient4 = new Ingredient("chicken",testFoodCategory2);
        ingredientRepo.save(testIngredient);
        ingredientRepo.save(testIngredient2);
        ingredientRepo.save(testIngredient3);
        ingredientRepo.save(testIngredient4);

        Preference testPreference = new Preference(testIngredient);
        Preference testPreference2 = new Preference(testIngredient2);
        Preference testPreference3 = new Preference(testIngredient3);
        Preference testPreference4 = new Preference(testIngredient4);
        preferenceRepo.save(testPreference);
        preferenceRepo.save(testPreference2);
        preferenceRepo.save(testPreference3);
        preferenceRepo.save(testPreference4);

        Allergy testAllergy = new Allergy("Lactose Tolerant");
        Allergy testAllergy2 = new Allergy("Peanut Allergy");
        Allergy testAllergy3 = new Allergy("Pollen");
        Allergy testAllergy4 = new Allergy("Fur");
        allergyRepo.save(testAllergy);
        allergyRepo.save(testAllergy2);
        allergyRepo.save(testAllergy3);
        allergyRepo.save(testAllergy4);

        Child testChild = new Child("1","2","3",testAllergy,testAllergy3);
        Child testChild2 = new Child("1","2","3",testAllergy4,testAllergy3);
        Child testChild3 = new Child("1","2","3",testAllergy2);
        Child testChild4 = new Child("1","2","3",testAllergy2);
        Child testChild5 = new Child("1","2","3",testAllergy2);
        childRepo.save(testChild);
        childRepo.save(testChild2);
        childRepo.save(testChild3);
        childRepo.save(testChild4);
        childRepo.save(testChild5);

        testChild.addPreference(testPreference);
        testChild.addPreference(testPreference2);
        testChild.addPreference(testPreference3);
        testChild2.addPreference(testPreference);
        testChild2.addPreference(testPreference2);
        testChild3.addPreference(testPreference4);
        testChild4.addPreference(testPreference);
        testChild4.addPreference(testPreference2);
        testChild4.addPreference(testPreference3);
        testChild4.addPreference(testPreference4);
        testChild5.addPreference(testPreference);

        Parent testParent1 = new Parent("John","Doe","JohnDoe18@gmail.com");
        Parent testParent2 = new Parent("Test","Subject","TestSubject@gmail.com");
        parentRepo.save(testParent1);
        parentRepo.save(testParent2);

        testParent1.addChild(testChild);
        testParent1.addChild(testChild2);
        testParent1.addChild(testChild5);
        testParent2.addChild(testChild3);
        testParent2.addChild(testChild4);

        testParent2.removeChild(testChild5);

        testParent1.addIngredient(testIngredient);
        testParent1.addIngredient(testIngredient2);
        testParent2.addIngredient(testIngredient3);
        testParent2.addIngredient(testIngredient4);

        testParent1.removeIngredient(testIngredient);
        testParent2.removeIngredient(testIngredient3);

        entityManager.flush();
        entityManager.clear();

        Parent retrievedParent1 = parentRepo.findById(testParent1.getId()).get();
        Parent retrievedParent2 = parentRepo.findById(testParent2.getId()).get();
        Ingredient retrievedIngredient1 = ingredientRepo.findById(testIngredient.getId()).get();
        Ingredient retrievedIngredient2 = ingredientRepo.findById(testIngredient2.getId()).get();
        Ingredient retrievedIngredient3 = ingredientRepo.findById(testIngredient3.getId()).get();
        Ingredient retrievedIngredient4 = ingredientRepo.findById(testIngredient4.getId()).get();
        assertThat(retrievedParent1.getIngredients()).contains(testIngredient2);
        assertThat(retrievedParent2.getIngredients()).contains(testIngredient4);
    }

    @Test
    public void shouldRemovePreferencesFromChild() {

        FoodCategory testFoodCategory = new FoodCategory("Dairy","dairy.jpg");
        FoodCategory testFoodCategory2 = new FoodCategory("Meat","meat.jpg");
        foodCategoryRepo.save(testFoodCategory);
        foodCategoryRepo.save(testFoodCategory2);

        Ingredient testIngredient = new Ingredient("milk1",testFoodCategory);
        Ingredient testIngredient2 = new Ingredient("Milk2",testFoodCategory);
        Ingredient testIngredient3 = new Ingredient("fish",testFoodCategory2);
        Ingredient testIngredient4 = new Ingredient("chicken",testFoodCategory2);
        ingredientRepo.save(testIngredient);
        ingredientRepo.save(testIngredient2);
        ingredientRepo.save(testIngredient3);
        ingredientRepo.save(testIngredient4);

        Preference testPreference = new Preference(testIngredient);
        Preference testPreference2 = new Preference(testIngredient2);
        Preference testPreference3 = new Preference(testIngredient3);
        Preference testPreference4 = new Preference(testIngredient4);
        preferenceRepo.save(testPreference);
        preferenceRepo.save(testPreference2);
        preferenceRepo.save(testPreference3);
        preferenceRepo.save(testPreference4);

        Allergy testAllergy = new Allergy("Lactose Tolerant");
        Allergy testAllergy2 = new Allergy("Peanut Allergy");
        Allergy testAllergy3 = new Allergy("Pollen");
        Allergy testAllergy4 = new Allergy("Fur");
        allergyRepo.save(testAllergy);
        allergyRepo.save(testAllergy2);
        allergyRepo.save(testAllergy3);
        allergyRepo.save(testAllergy4);

        Child testChild = new Child("1","2","3",testAllergy,testAllergy3);
        Child testChild2 = new Child("1","2","3",testAllergy4,testAllergy3);
        Child testChild3 = new Child("1","2","3",testAllergy2);
        Child testChild4 = new Child("1","2","3",testAllergy2);
        Child testChild5 = new Child("1","2","3",testAllergy2);
        childRepo.save(testChild);
        childRepo.save(testChild2);
        childRepo.save(testChild3);
        childRepo.save(testChild4);
        childRepo.save(testChild5);

        testChild.addPreference(testPreference);
        testChild.addPreference(testPreference2);
        testChild.addPreference(testPreference3);
        testChild2.addPreference(testPreference);
        testChild2.addPreference(testPreference2);
        testChild3.addPreference(testPreference4);
        testChild4.addPreference(testPreference);
        testChild4.addPreference(testPreference2);
        testChild4.addPreference(testPreference3);
        testChild4.addPreference(testPreference4);
        testChild5.addPreference(testPreference);

        testChild4.removePreference(testPreference4);
        testChild4.removePreference(testPreference);

        Parent testParent1 = new Parent("John","Doe","JohnDoe18@gmail.com");
        Parent testParent2 = new Parent("Test","Subject","TestSubject@gmail.com");
        parentRepo.save(testParent1);
        parentRepo.save(testParent2);

        testParent1.addChild(testChild);
        testParent1.addChild(testChild2);
        testParent1.addChild(testChild5);
        testParent2.addChild(testChild3);
        testParent2.addChild(testChild4);

        testParent2.removeChild(testChild5);

        testParent1.addIngredient(testIngredient);
        testParent1.addIngredient(testIngredient2);
        testParent2.addIngredient(testIngredient3);
        testParent2.addIngredient(testIngredient4);

        testParent1.removeIngredient(testIngredient);
        testParent2.removeIngredient(testIngredient3);

        entityManager.flush();
        entityManager.clear();

        Child retrievedChild = childRepo.findById(testChild4.getId()).get();
        Preference testPreferenceR2 = preferenceRepo.findById(testPreference2.getId()).get();
        Preference testPreferenceR3 = preferenceRepo.findById(testPreference3.getId()).get();
        assertThat(retrievedChild.getPreferences()).contains(testPreference2,testPreference3);
    }

}
