package com.macgyverfoods.pickyeater.rest.controllers;

import com.macgyverfoods.pickyeater.models.Child;
import com.macgyverfoods.pickyeater.models.Ingredient;
import com.macgyverfoods.pickyeater.models.Parent;
import com.macgyverfoods.pickyeater.repositories.ChildRepository;
import com.macgyverfoods.pickyeater.repositories.IngredientRepository;
import com.macgyverfoods.pickyeater.repositories.ParentRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @GetMapping("/parents")
    public Collection<Parent> getParents() {
        return (Collection<Parent>) parentRepo.findAll();
    }

    @GetMapping("/parents/{id}")
    public Optional<Parent> getParent(@PathVariable Long id) {
        return parentRepo.findById(id);
    }

    @PostMapping("/parents/{id}/add-ingredients")
    public Optional<Parent> addIngredients(@RequestBody String body, @PathVariable Long id) throws JSONException {
        JSONObject newIngredient = new JSONObject(body);
        String ingredientName = newIngredient.getString("ingredientName");
        Optional<Ingredient> ingredientToAddOpt = ingredientRepo.findByIngredient(ingredientName);
        if (ingredientToAddOpt.isPresent()) {
            Optional<Parent> parentToAddIngredientToOpt = parentRepo.findById(id);
            Parent parentToAddIngredientTo = parentToAddIngredientToOpt.get();
            parentToAddIngredientTo.addIngredient(ingredientToAddOpt.get());
            parentRepo.save(parentToAddIngredientTo);
        }

        return parentRepo.findById(id);
    }

    @PostMapping("/parents/{id}/delete-ingredients/{ingredientId}")
    public String removeIngredient(@PathVariable Long id, @PathVariable Long ingredientId) {
        Optional<Ingredient> ingredientToRemoveOpt = ingredientRepo.findById(ingredientId);
        Ingredient ingredientToRemove = ingredientToRemoveOpt.get();

        Optional<Parent> parentToRemoveIngredientFromOpt = parentRepo.findById(id);
        Parent parentToRemoveIngredientFrom = parentToRemoveIngredientFromOpt.get();
        parentToRemoveIngredientFrom.removeIngredient(ingredientToRemove);

        return "redirect:/parents/" + id;
    }

    @PostMapping("/parents/{id}/add-children")
    public Optional<Parent> addChildren(@RequestBody String body, @PathVariable Long id) throws JSONException {
        JSONObject newChild = new JSONObject(body);
        String childName = newChild.getString("childName");
        Optional<Child> childToAddOpt = childRepo.findByName(childName);
        if (childToAddOpt.isPresent()) {
            Optional<Parent> parentToAddChildToOpt = parentRepo.findById(id);
            Parent parentToAddChildTo = parentToAddChildToOpt.get();
            parentToAddChildTo.addChild(childToAddOpt.get());
            parentRepo.save(parentToAddChildTo);
        }

        return parentRepo.findById(id);
    }

    @PostMapping("/parents/{id}/delete-children/{childId}")
    public String removeChild(@PathVariable Long id, @PathVariable Long childId) {
        Optional<Child> childToRemoveOpt = childRepo.findById(childId);
        Child childToRemove = childToRemoveOpt.get();

        Optional<Parent> parentToRemoveChildFromOpt = parentRepo.findById(id);
        Parent parentToRemoveChildFrom = parentToRemoveChildFromOpt.get();
        parentToRemoveChildFrom.removeChild(childToRemove);

        return "redirect:/parents/" + id;
    }
}