package com.macgyverfoods.pickyeater.rest.controllers;

import com.macgyverfoods.pickyeater.models.Allergy;
import com.macgyverfoods.pickyeater.repositories.AllergyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
public class AllergyRestController {

    @Resource
    private AllergyRepository allergyRepo;

    @GetMapping("/allergies")
    public Collection<Allergy> getAllergies() {

        return (Collection<Allergy>) allergyRepo.findAll();
    }

    @GetMapping("/allergies/{id}")
    public Allergy getAllergy(@PathVariable Long id) {

        return allergyRepo.findById(id).get();
    }

}