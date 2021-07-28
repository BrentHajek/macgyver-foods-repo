package com.macgyverfoods.pickyeater.rest.controllers;

import com.macgyverfoods.pickyeater.models.Ingredient;
import com.macgyverfoods.pickyeater.repositories.IngredientRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Optional;

@RestController
public class IngredientRestController {

    @Resource
    private IngredientRepository ingredientRepo;

    @GetMapping("/ingredients")
    public Collection<Ingredient> getIngredients() {

        return (Collection<Ingredient>) ingredientRepo.findAll();
    }

    @GetMapping("/ingredients/{id}")
    public Ingredient getIngredient(@PathVariable Long id) {

        return ingredientRepo.findById(id).get();
    }

}