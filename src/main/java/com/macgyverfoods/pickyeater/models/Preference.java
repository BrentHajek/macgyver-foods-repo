package com.macgyverfoods.pickyeater.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Preference {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "preferences")
    private Collection<Ingredient> preferredIngredients;

    @ManyToMany(mappedBy = "preferences")
    private Collection<Child> children;

    public Long getId() {
        return id;
    }

    public Collection<Ingredient> getIngredients() {
        return preferredIngredients;
    }

    public Collection<Child> getChildren() {
        return children;
    }

    public Preference() {}

    public Preference(Collection<Ingredient> ingredients, Collection<Child> children) {
        this.preferredIngredients = ingredients;
        this.children = children;
    }
}
