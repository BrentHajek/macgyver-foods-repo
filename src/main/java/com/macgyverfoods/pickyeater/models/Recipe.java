package com.macgyverfoods.pickyeater.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;

    private String recipe;

    @ManyToOne
    @JsonIgnore
    private Child child;

    public Recipe(String recipe, Child child) {
        this.recipe = recipe;
        this.child = child;
    }

    public Long getId() {
        return id;
    }

    public String getRecipe() {
        return recipe;
    }

    public Child getChild() {
        return child;
    }

    public Recipe() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(id, recipe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
