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

    private String ingredientName;

    @OneToOne
    private Preference preferences;

    @ManyToOne
    private Parent parent;

    public Long getId() {
        return id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public Preference getPreferences() {
        return preferences;
    }

    public Parent getParent() {
        return parent;
    }

    public Ingredient(String ingredientName) {
        this.ingredientName = ingredientName;
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
