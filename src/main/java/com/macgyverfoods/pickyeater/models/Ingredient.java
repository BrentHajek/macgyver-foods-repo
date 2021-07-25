package com.macgyverfoods.pickyeater.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Collection<Preference> preferences;
}
