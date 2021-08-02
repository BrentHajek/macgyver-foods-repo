package com.macgyverfoods.pickyeater.rest.controllers;

import com.macgyverfoods.pickyeater.models.*;
import com.macgyverfoods.pickyeater.repositories.AllergyRepository;
import com.macgyverfoods.pickyeater.repositories.ChildRepository;
import com.macgyverfoods.pickyeater.repositories.PreferenceRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Optional;

@RestController
public class ChildRestController {

    @Resource
    private ChildRepository childRepo;

    @Resource
    private PreferenceRepository preferenceRepo;

    @Resource
    private AllergyRepository allergyRepo;

    @GetMapping("/children")
    public Collection<Child> getChildren() {

        return (Collection<Child>) childRepo.findAll();
    }

    @GetMapping("/children/{id}")
    public Child getChild(@PathVariable Long id) {

        return childRepo.findById(id).get();
    }

    @PostMapping("/children/{id}/add-preference")
    public Optional<Child> addPreferences(@RequestBody String body, @PathVariable Long id) throws JSONException {
        JSONObject newPreference = new JSONObject(body);
        String preference = newPreference.getString("preference");
        Optional<Preference> preferenceToAddOpt = preferenceRepo.findByPreference(preference);
        if (preferenceToAddOpt.isPresent()) {
            Optional<Child> childToAddPreferenceToOpt = childRepo.findById(id);
            Child childToAddPreferenceTo = childToAddPreferenceToOpt.get();
            childToAddPreferenceTo.addPreference(preferenceToAddOpt.get());
            childRepo.save(childToAddPreferenceTo);
        }

        return childRepo.findById(id);
    }

    @DeleteMapping ("/children/{id}/delete-preference")
    public Optional<Child> removePreference(@RequestBody String body, @PathVariable Long id) {
        JSONObject removedPreference = new JSONObject(body);
        String preference = removedPreference.getString("preference");
        Optional<Preference> preferenceToRemoveOpt = preferenceRepo.findByPreference(preference);
        if (preferenceToRemoveOpt.isPresent()){
            Optional<Child> childToRemovePreferenceFromOpt = childRepo.findById(id);
            Child childToRemovePreferenceFrom = childToRemovePreferenceFromOpt.get();
            childToRemovePreferenceFrom.removePreference(preferenceToRemoveOpt.get());
            childRepo.save(childToRemovePreferenceFrom);
        }
        return childRepo.findById(id);
    }

    @PostMapping("/children/{id}/add-allergy")
    public Optional<Child> addAllergies(@RequestBody String body, @PathVariable Long id) throws JSONException {
        JSONObject newAllergy = new JSONObject(body);
        String allergy = newAllergy.getString("allergy");
        Optional<Allergy> allergyToAddOpt = allergyRepo.findByAllergy(allergy);
        if (allergyToAddOpt.isPresent()) {
            Optional<Child> childToAddAllergyToOpt = childRepo.findById(id);
            Child childToAddAllergyTo = childToAddAllergyToOpt.get();
            childToAddAllergyTo.addAllergy(allergyToAddOpt.get());
            childRepo.save(childToAddAllergyTo);
        }

        return childRepo.findById(id);
    }

    @DeleteMapping("/children/{id}/delete-allergy")
    public Optional<Child> removeAllergies(@RequestBody String body, @PathVariable Long id) throws JSONException {
        JSONObject removeAllergy = new JSONObject(body);
        String allergy = removeAllergy.getString("allergy");
        Optional<Allergy> allergyToAddOpt = allergyRepo.findByAllergy(allergy);
        if (allergyToAddOpt.isPresent()) {
            Optional<Child> childToAddAllergyToOpt = childRepo.findById(id);
            Child childToAddAllergyTo = childToAddAllergyToOpt.get();
            childToAddAllergyTo.removeAllergy(allergyToAddOpt.get());
            childRepo.save(childToAddAllergyTo);
        }

        return childRepo.findById(id);
    }

}