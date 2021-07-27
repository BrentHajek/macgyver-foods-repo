package com.macgyverfoods.pickyeater.repositories;

import com.macgyverfoods.pickyeater.models.FoodCategory;
import org.springframework.data.repository.CrudRepository;

public interface FoodCategoryRepository extends CrudRepository<FoodCategory,Long> {
}
