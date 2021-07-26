package com.macgyverfoods.pickyeater.models;

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

    @OneToMany
    private Set<Child> children;

    @OneToMany
    private Collection<Ingredient> ingredients;

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

    public Parent(String parentFirstName, String parentLastName, String email, Ingredient ...ingredients) {
        this.parentFirstName = parentFirstName;
        this.parentLastName = parentLastName;
        this.email = email;
        this.children = new HashSet<>();
        new ArrayList<>(Arrays.asList(ingredients));
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
