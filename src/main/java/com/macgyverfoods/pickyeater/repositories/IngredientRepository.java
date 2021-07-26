package com.macgyverfoods.pickyeater.repositories;

import com.macgyverfoods.pickyeater.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient,Long> {
}
