package com.macgyverfoods.pickyeater.repositories;

import com.macgyverfoods.pickyeater.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient,Long> {
    Optional<Ingredient> findByIngredient(String ingredient);
}
