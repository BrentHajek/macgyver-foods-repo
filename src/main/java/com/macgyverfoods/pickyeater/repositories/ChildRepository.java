package com.macgyverfoods.pickyeater.repositories;

import com.macgyverfoods.pickyeater.models.Child;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ChildRepository extends CrudRepository<Child,Long> {

    Optional<Child> findByFirstName(String firstName);
}
