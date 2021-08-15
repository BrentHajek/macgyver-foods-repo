package com.macgyverfoods.pickyeater.rest.controllers;

import com.macgyverfoods.pickyeater.models.*;
import com.macgyverfoods.pickyeater.repositories.RecipeRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@CrossOrigin
public class RecipeRestController {

    @Resource
    private RecipeRepository recipeRepo;

    @GetMapping ("/recipes")
    public Collection<Recipe> getRecipes(){
        return (Collection<Recipe>) recipeRepo.findAll();
    }

    @GetMapping ("/recipes/{id}")
    public Recipe getRecipe(@PathVariable Long id){
        return recipeRepo.findById(id).get();
    }



}
