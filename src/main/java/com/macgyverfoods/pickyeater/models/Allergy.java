package com.macgyverfoods.pickyeater.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Allergy {

    @Id
    @GeneratedValue
    private Long id;

    private String allergy;

    @ManyToMany (mappedBy = "allergies")
    @JsonIgnore
    private Collection<Child> children;

    public Long getId() {
        return id;
    }

    public String getAllergy() {
        return allergy;
    }

    public Collection<Child> getChildren() {
        return children;
    }

    public Allergy(String allergy) {
        this.allergy = allergy;
    }

    public Allergy() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allergy allergy = (Allergy) o;
        return Objects.equals(id, allergy.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
