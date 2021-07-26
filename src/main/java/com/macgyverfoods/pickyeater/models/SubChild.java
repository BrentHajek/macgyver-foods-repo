package com.macgyverfoods.pickyeater.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class SubChild {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String age;

    @ManyToMany
    private Collection<Allergy> allergies;

    @OneToOne
    private Child child;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public Collection<Allergy> getAllergies() {
        return allergies;
    }

    public Child getChild() {
        return child;
    }

    public SubChild(String firstName, String lastName, String age, Allergy...allergies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.allergies = new ArrayList<>(Arrays.asList(allergies));
    }

    public SubChild() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubChild subChild = (SubChild) o;
        return Objects.equals(id, subChild.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
