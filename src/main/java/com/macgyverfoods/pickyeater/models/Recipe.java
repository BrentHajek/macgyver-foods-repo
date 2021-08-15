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
    private String ingredient;
    private String instruction;

    @ManyToOne
    private Child child;

    public Recipe(String recipe, String ingredient, String instruction, Child child) {
        this.ingredient = ingredient;
        this.instruction = instruction;
        this.child = child;
    }

    public Long getId() {
        return id;
    }

    public String getRecipe() {
        return recipe;
    }

    public String getIngredient() {
        return ingredient;
    }

    public String getInstruction() {
        return instruction;
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
        Recipe recipe1 = (Recipe) o;
        return Objects.equals(id, recipe1.id) && Objects.equals(recipe, recipe1.recipe) && Objects.equals(ingredient, recipe1.ingredient) && Objects.equals(instruction, recipe1.instruction) && Objects.equals(child, recipe1.child);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipe, ingredient, instruction, child);
    }
}
