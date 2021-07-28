package com.macgyverfoods.pickyeater.rest.controllers;

import com.macgyverfoods.pickyeater.models.Ingredient;
import com.macgyverfoods.pickyeater.models.Preference;
import com.macgyverfoods.pickyeater.repositories.PreferenceRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Optional;

@RestController
public class PreferenceRestController {

    @Resource
    private PreferenceRepository preferenceRepo;

    @GetMapping("/preferences")
    public Collection<Preference> getPreferences() {

        return (Collection<Preference>) preferenceRepo.findAll();
    }

    @GetMapping("/preferences/{id}")
    public Preference getPreference(@PathVariable Long id) {

        return preferenceRepo.findById(id).get();
    }

}