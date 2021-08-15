package com.macgyverfoods.pickyeater.repositories;

import com.macgyverfoods.pickyeater.models.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    Optional<Recipe> findByRecipe(String recipe);
}
