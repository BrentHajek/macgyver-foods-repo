package com.macgyverfoods.pickyeater.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Child {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String age;

    @ManyToMany
    private Collection<Preference> preferences;

    @ManyToMany
    private Collection<Allergy> allergies;

    @ManyToOne
    private Parent parent;

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

    public Collection<Preference> getPreferences() {
        return preferences;
    }

    public Collection<Allergy> getAllergies() {
        return allergies;
    }

    public Parent getParent() {
        return parent;
    }

    public Child() {}

    public Child(String firstName, String lastName, String age, Collection<Preference> preferences,
                 Collection<Allergy> allergies, Parent parent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.preferences = preferences;
        this.allergies = allergies;
        this.parent = parent;
    }
}
