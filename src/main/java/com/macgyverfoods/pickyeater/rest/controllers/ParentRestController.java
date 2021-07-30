package com.macgyverfoods.pickyeater.rest.controllers;

import com.macgyverfoods.pickyeater.models.Allergy;
import com.macgyverfoods.pickyeater.models.Child;
import com.macgyverfoods.pickyeater.models.Ingredient;
import com.macgyverfoods.pickyeater.models.Parent;
import com.macgyverfoods.pickyeater.repositories.AllergyRepository;
import com.macgyverfoods.pickyeater.repositories.ChildRepository;
import com.macgyverfoods.pickyeater.repositories.IngredientRepository;
import com.macgyverfoods.pickyeater.repositories.ParentRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RestController
@CrossOrigin
public class ParentRestController {

    @Resource
    private ParentRepository parentRepo;

    @Resource
    private IngredientRepository ingredientRepo;

    @Resource
    private ChildRepository childRepo;

    @Resource
    private AllergyRepository allergyRepo;

    @GetMapping("/parents")
    public Collection<Parent> getParents() {
        return (Collection<Parent>) parentRepo.findAll();
    }

    @GetMapping("/parents/{id}")
    public Optional<Parent> getParent(@PathVariable Long id) {
        return parentRepo.findById(id);
    }

    @PostMapping("/parents/{id}/add-ingredient")
    public Optional<Parent> addIngredients(@RequestBody String body, @PathVariable Long id) throws JSONException {
        JSONObject newIngredient = new JSONObject(body);
        String ingredient = newIngredient.getString("ingredient");
        Optional<Ingredient> ingredientToAddOpt = ingredientRepo.findByIngredient(ingredient);
        if (ingredientToAddOpt.isPresent()) {
            Optional<Parent> parentToAddIngredientToOpt = parentRepo.findById(id);
            Parent parentToAddIngredientTo = parentToAddIngredientToOpt.get();
            parentToAddIngredientTo.addIngredient(ingredientToAddOpt.get());
            parentRepo.save(parentToAddIngredientTo);
        }
        return parentRepo.findById(id);
    }

    @PostMapping("/parents/{id}/add-children")
    public Optional<Parent> addChildren(@RequestBody String body, @PathVariable Long id) throws JSONException {
        JSONObject newChild = new JSONObject(body);
        String firstName = newChild.getString("firstName");
        String lastName = newChild.getString("lastName");
        String age = newChild.getString("age");
        Optional<Child> childToAddOpt = childRepo.findByFirstName(firstName);
        if (childToAddOpt.isEmpty()) {
                Child childToAdd = new Child(firstName,lastName,age);
                childRepo.save(childToAdd);
                Optional<Parent> parentToAddChild2Opt = parentRepo.findById(id);
                Parent parentToAddChild2 = parentToAddChild2Opt.get();
                parentToAddChild2.addChild(childToAdd);
                parentRepo.save(parentToAddChild2);
        }
        return parentRepo.findById(id);
    }

    @DeleteMapping("/parents/{id}/delete-ingredients/{ingredientId}")
    public String removeIngredient(@PathVariable Long id, @PathVariable Long ingredientId) {
        Optional<Ingredient> ingredientToRemoveOpt = ingredientRepo.findById(ingredientId);
        Ingredient ingredientToRemove = ingredientToRemoveOpt.get();

        Optional<Parent> parentToRemoveIngredientFromOpt = parentRepo.findById(id);
        Parent parentToRemoveIngredientFrom = parentToRemoveIngredientFromOpt.get();
        parentToRemoveIngredientFrom.removeIngredient(ingredientToRemove);

        return "redirect:/parents/" + id;
    }

    @DeleteMapping("/parents/{id}/delete-children/{childId}")
    public String removeChild(@PathVariable Long id, @PathVariable Long childId) {
        Optional<Child> childToRemoveOpt = childRepo.findById(childId);
        Child childToRemove = childToRemoveOpt.get();

        Optional<Parent> parentToRemoveChildFromOpt = parentRepo.findById(id);
        Parent parentToRemoveChildFrom = parentToRemoveChildFromOpt.get();
        parentToRemoveChildFrom.removeChild(childToRemove);

        return "redirect:/parents/" + id;
    }
}