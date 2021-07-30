package com.macgyverfoods.pickyeater.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
public class Parent {

    @Id
    @GeneratedValue
    private Long id;

    private String parentFirstName;
    private String parentLastName;
    private String email;

    @OneToMany (mappedBy = "parent")
    private Set<Child> children;

    @ManyToMany
    private Set<Ingredient> ingredients;

    public Long getId() {
        return id;
    }

    public String getParentFirstName() {
        return parentFirstName;
    }

    public String getParentLastName() {
        return parentLastName;
    }

    public String getEmail() {
        return email;
    }

    public Collection<Child> getChild() {
        return children;
    }

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addChild(Child childToAdd) {
        children.add(childToAdd);
    }

    public void removeChild(Child childToRemove) {
        children.remove(childToRemove);
    }

    public void addIngredient(Ingredient ingredientToAdd) {
        ingredients.add(ingredientToAdd);
    }

    public void removeIngredient(Ingredient ingredientToRemove) {
        ingredients.remove(ingredientToRemove);
    }

    public Parent(String parentFirstName, String parentLastName, String email) {
        this.parentFirstName = parentFirstName;
        this.parentLastName = parentLastName;
        this.email = email;
        this.children = new HashSet<>();
        this.ingredients = new HashSet<>();
    }

    public Parent() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parent parent = (Parent) o;
        return Objects.equals(id, parent.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
