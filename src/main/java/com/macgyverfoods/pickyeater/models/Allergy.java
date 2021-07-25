package com.macgyverfoods.pickyeater.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
public class Allergy {

    @Id
    @GeneratedValue
    private Long id;

    private String allergyType;

    @ManyToMany(mappedBy = "allergies")
    private Collection<Child> children;
}
