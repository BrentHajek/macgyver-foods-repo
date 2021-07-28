package com.macgyverfoods.pickyeater.models;

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

    private String allergyType;

    @ManyToMany (mappedBy = "allergies")
    private Collection<Child> children;

    public Long getId() {
        return id;
    }

    public String getAllergyType() {
        return allergyType;
    }

    public Collection<Child> getChildren() {
        return children;
    }

    public Allergy(String allergyType) {
        this.allergyType = allergyType;
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
