package com.macgyverfoods.pickyeater.repositories;

import com.macgyverfoods.pickyeater.models.Preference;
import org.springframework.data.repository.CrudRepository;

public interface PreferenceRepository extends CrudRepository<Preference,Long> {
}
