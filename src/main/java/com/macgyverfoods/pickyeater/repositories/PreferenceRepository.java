package com.macgyverfoods.pickyeater.repositories;

import com.macgyverfoods.pickyeater.models.Preference;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PreferenceRepository extends CrudRepository<Preference,Long> {
    Optional<Preference> findByPreference(String preference);
}
