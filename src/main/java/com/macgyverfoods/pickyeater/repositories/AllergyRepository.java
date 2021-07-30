package com.macgyverfoods.pickyeater.repositories;

import com.macgyverfoods.pickyeater.models.Allergy;
import org.json.JSONObject;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AllergyRepository extends CrudRepository<Allergy,Long> {

    Optional<Allergy> findByAllergy(String allergy);
}
