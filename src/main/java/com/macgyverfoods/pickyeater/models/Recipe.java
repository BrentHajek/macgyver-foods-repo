package com.macgyverfoods.pickyeater.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;

    private String ingredient;
    private String instruction;

    @ManyToMany (mappedBy = "recipe")
    private Collection <Child> children;

    public Recipe(String ingredient, String instruction, Collection<Child> children) {
        this.ingredient = ingredient;
        this.instruction = instruction;
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public String getIngredient() {
        return ingredient;
    }

    public String getInstruction() {
        return instruction;
    }

    public Collection<Child> getChildren() {
        return children;
    }

    public Recipe() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(id, recipe.id) && Objects.equals(ingredient, recipe.ingredient) && Objects.equals(instruction, recipe.instruction) && Objects.equals(children, recipe.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ingredient, instruction, children);
    }
}
