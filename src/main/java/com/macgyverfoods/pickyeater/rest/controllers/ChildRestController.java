package com.macgyverfoods.pickyeater.rest.controllers;

import com.macgyverfoods.pickyeater.models.*;
import com.macgyverfoods.pickyeater.repositories.AllergyRepository;
import com.macgyverfoods.pickyeater.repositories.ChildRepository;
import com.macgyverfoods.pickyeater.repositories.PreferenceRepository;
import com.macgyverfoods.pickyeater.repositories.RecipeRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ChildRestController {

    @Resource
    private ChildRepository childRepo;

    @Resource
    private PreferenceRepository preferenceRepo;

    @Resource
    private AllergyRepository allergyRepo;

    @Resource
    private RecipeRepository recipeRepo;

    @GetMapping("/children")
    public Collection<Child> getChildren() {

        return (Collection<Child>) childRepo.findAll();
    }

    @GetMapping("/children/{id}")
    public Child getChild(@PathVariable Long id) {

        return childRepo.findById(id).get();
    }

    @GetMapping("/children/{id}/allergies")
    public Collection<Allergy> getChildAllergies(@PathVariable Long id) {
        Optional<Child> childToGetAllergiesFor = Optional.of(childRepo.findById(id).get());
        return childToGetAllergiesFor.get().getAllergies();
    }

    @GetMapping("/children/{id}/preferences")
    public Collection<Preference> getChildPreferences(@PathVariable Long id) {
        Optional<Child> childToGetPreferencesFor = Optional.of(childRepo.findById(id).get());
        return childToGetPreferencesFor.get().getPreferences();
    }

    @PostMapping("/children/{id}/add-preference")
    public Optional<Child> addPreferences(@RequestBody String body, @PathVariable Long id) throws JSONException {
        JSONObject newPreference = new JSONObject(body);
        String preference = newPreference.getString("preference");
        Optional<Preference> preferenceToAddOpt = preferenceRepo.findByPreference(preference);
        if (preferenceToAddOpt.isPresent()) {
            Optional<Child> childToAddPreferenceToOpt = childRepo.findById(id);
            Child childToAddPreferenceTo = childToAddPreferenceToOpt.get();
            childToAddPreferenceTo.addPreference(preferenceToAddOpt.get());
            childRepo.save(childToAddPreferenceTo);
        }

        return childRepo.findById(id);
    }

    @DeleteMapping ("/children/{id}/delete-preference")
    public Optional<Child> removePreference(@RequestBody String body, @PathVariable Long id) throws JSONException {
        JSONObject removedPreference = new JSONObject(body);
        String preference = removedPreference.getString("preference");
        Optional<Preference> preferenceToRemoveOpt = preferenceRepo.findByPreference(preference);
        if (preferenceToRemoveOpt.isPresent()){
            Optional<Child> childToRemovePreferenceFromOpt = childRepo.findById(id);
            Child childToRemovePreferenceFrom = childToRemovePreferenceFromOpt.get();
            childToRemovePreferenceFrom.removePreference(preferenceToRemoveOpt.get());
            childRepo.save(childToRemovePreferenceFrom);
        }
        return childRepo.findById(id);
    }

    @PostMapping("/children/{id}/add-allergy")
    public Optional<Child> addAllergies(@RequestBody String body, @PathVariable Long id) throws JSONException {
        JSONObject newAllergy = new JSONObject(body);
        String allergy = newAllergy.getString("allergy");
        Optional<Allergy> allergyToAddOpt = allergyRepo.findByAllergy(allergy);
        if (allergyToAddOpt.isPresent()) {
            Optional<Child> childToAddAllergyToOpt = childRepo.findById(id);
            Child childToAddAllergyTo = childToAddAllergyToOpt.get();
            childToAddAllergyTo.addAllergy(allergyToAddOpt.get());
            childRepo.save(childToAddAllergyTo);
        }

        return childRepo.findById(id);
    }

    @DeleteMapping("/children/{id}/delete-allergy")
    public Optional<Child> removeAllergies(@RequestBody String body, @PathVariable Long id) throws JSONException {
        JSONObject removeAllergy = new JSONObject(body);
        String allergy = removeAllergy.getString("allergy");
        Optional<Allergy> allergyToRemoveOpt = allergyRepo.findByAllergy(allergy);
        if (allergyToRemoveOpt.isPresent()) {
            Optional<Child> childToRemoveAllergyFromOpt = childRepo.findById(id);
            Child childToRemoveAllergyFrom = childToRemoveAllergyFromOpt.get();
            childToRemoveAllergyFrom.removeAllergy(allergyToRemoveOpt.get());
            childRepo.save(childToRemoveAllergyFrom);
        }

        return childRepo.findById(id);
    }

    @PostMapping("/children/{id}/add-recipe")
    public Optional<Child> addRecipes(@RequestBody String body, @PathVariable Long id) throws JSONException {
        JSONObject newRecipe = new JSONObject(body);
        String recipe = newRecipe.getString("recipe");
        Optional<Recipe> recipeToAddOpt = recipeRepo.findByRecipe(recipe);
        if (recipeToAddOpt.isEmpty()) {
            Child childToAddRecipeToOpt = childRepo.findById(id).get();
            Recipe recipeToAdd = new Recipe(recipe,childToAddRecipeToOpt);
            recipeRepo.save(recipeToAdd);
            childRepo.save(childToAddRecipeToOpt);
        }

        return childRepo.findById(id);
    }

    @DeleteMapping ("/children/{id}/delete-recipe")
    public Optional<Child> removeRecipe(@RequestBody String body, @PathVariable Long id) {
        JSONObject removedRecipe = new JSONObject(body);
        String recipe = removedRecipe.getString("recipe");
        Optional<Recipe> recipeToRemoveOpt = recipeRepo.findByRecipe(recipe);
        if (recipeToRemoveOpt.isPresent()){
            Child childToRemoveRecipeFrom = childRepo.findById(id).get();
            recipeRepo.delete(recipeToRemoveOpt.get());
            childRepo.save(childToRemoveRecipeFrom);
        }
        return childRepo.findById(id);
    }
}