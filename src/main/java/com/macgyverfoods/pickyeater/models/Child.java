package com.macgyverfoods.pickyeater.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
public class Child {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String age;

    @ManyToMany
    private Set<Preference> preferences;

    @ManyToMany
    private Set<Allergy> allergies;

    @ManyToOne
    @JsonIgnore
    private Parent parent;

    @OneToMany
    @JsonIgnore
    private Collection<Recipe> recipes;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public Parent getParent() {
        return parent;
    }

    public Collection<Allergy> getAllergies() {
        return allergies;
    }

    public Collection<Preference> getPreferences() {
        return preferences;
    }

    public void addPreference(Preference preferenceToAdd) {
        preferences.add(preferenceToAdd);
    }

    public void removePreference(Preference preferenceToRemove) {
        preferences.remove(preferenceToRemove);
    }

    public void addAllergy(Allergy allergyToAdd) {
        allergies.add(allergyToAdd);
    }

    public void removeAllergy(Allergy allergyToRemove) {
        allergies.remove(allergyToRemove);
    }

    public void addRecipe(Recipe recipeToAdd) {recipes.add(recipeToAdd);
    }

    public void removeRecipe(Recipe recipeToRemove) {recipes.remove(recipeToRemove);
    }

    public Child(String firstName, String lastName, String age, Parent parent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.allergies = new HashSet<>();
        this.preferences = new HashSet<>();
        this.parent = parent;
    }

    public Child() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return Objects.equals(id, child.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
