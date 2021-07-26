package com.macgyverfoods.pickyeater.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Preference {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Ingredient preferredIngredients;

    @ManyToMany(mappedBy = "preferences")
    private Collection<Child> children;

    public Long getId() {
        return id;
    }

    public Ingredient getIngredients() {
        return preferredIngredients;
    }

    public Collection<Child> getChildren() {
        return children;
    }

    public Preference() {

    }

    public Preference(Ingredient ingredients) {
        this.preferredIngredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preference that = (Preference) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
