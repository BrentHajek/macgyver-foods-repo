package com.macgyverfoods.pickyeater.rest.controllers;

import com.macgyverfoods.pickyeater.models.Child;
import com.macgyverfoods.pickyeater.models.Ingredient;
import com.macgyverfoods.pickyeater.models.Parent;
import com.macgyverfoods.pickyeater.models.Preference;
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

    @GetMapping("/children")
    public Collection<Child> getChildren() {

        return (Collection<Child>) childRepo.findAll();
    }

    @GetMapping("/children/{id}")
    public Child getChild(@PathVariable Long id) {

        return childRepo.findById(id).get();
    }

    @PostMapping("/children/{id}/add-preferences")
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

    @PostMapping("/children/{id}/delete-preferences/{preferenceId}")
    public String removePreference(@PathVariable Long id, @PathVariable Long preferenceId) {
        Optional<Preference> preferenceToRemoveOpt = preferenceRepo.findById(preferenceId);
        Preference preferenceToRemove = preferenceToRemoveOpt.get();

        Optional<Child> childToRemovePreferenceFromOpt = childRepo.findById(id);
        Child childToRemovePreferenceFrom = childToRemovePreferenceFromOpt.get();
        childToRemovePreferenceFrom.removePreference(preferenceToRemove);

        return "redirect:/children/" + id;
    }

}