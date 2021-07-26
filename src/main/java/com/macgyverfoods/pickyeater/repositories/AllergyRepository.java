package com.macgyverfoods.pickyeater.repositories;

import com.macgyverfoods.pickyeater.models.Allergy;
import org.springframework.data.repository.CrudRepository;

public interface AllergyRepository extends CrudRepository<Allergy,Long> {
}
