package com.macgyverfoods.pickyeater.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;

    private String ingredient;

    @OneToOne
    @JsonIgnore
    private Preference preferences;

    @ManyToOne
    private FoodCategory foodCategory;

    @ManyToMany
    private Collection<Parent> parents;

    public Long getId() {
        return id;
    }

    public String getIngredient() {
        return ingredient;
    }

    public Preference getPreferences() {
        return preferences;
    }

    public Collection<Parent> getParent() {
        return parents;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public Ingredient(String ingredient, FoodCategory foodCategory) {
        this.ingredient = ingredient;
        this.foodCategory = foodCategory;
    }

    public Ingredient(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
