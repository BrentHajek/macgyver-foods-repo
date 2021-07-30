package com.macgyverfoods.pickyeater.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Preference {

    @Id
    @GeneratedValue
    private Long id;

    private String preference;

    @ManyToOne
    private FoodCategory foodCategory;

    @ManyToMany(mappedBy = "preferences")
    @JsonIgnore
    private Collection<Child> children;

    public Long getId() {
        return id;
    }

    public String getPreference() {
        return preference;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public Collection<Child> getChildren() {
        return children;
    }

    public Preference() {

    }

    public Preference(String preference, FoodCategory foodCategory) {
        this.preference = preference;
        this.foodCategory = foodCategory;
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
