package com.macgyverfoods.pickyeater.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Child {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private SubChild subChild;

    @ManyToMany
    private Collection<Preference> preferences;

    @ManyToOne
    private Parent parent;

    public Long getId() {
        return id;
    }

    public Collection<Preference> getPreferences() {
        return preferences;
    }

    public SubChild getSubChild() {
        return subChild;
    }

    public Parent getParent() {
        return parent;
    }

    public Child(SubChild subChild, Preference...preferences) {
        this.subChild = subChild;
        this.preferences = new ArrayList<>(Arrays.asList(preferences));
    }

    public Child() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return Objects.equals(id, child.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
