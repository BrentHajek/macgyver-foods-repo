package com.macgyverfoods.pickyeater.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class FoodCategory {

    @Id
    @GeneratedValue
    private Long id;

    private String foodCategoryName;
    private String foodCategoryImg;

    @OneToMany (mappedBy = "foodCategory")
    @JsonIgnore
    private Collection<Ingredient> ingredient;

    @OneToMany (mappedBy = "foodCategory")
    @JsonIgnore
    private Collection<Preference> preference;

    public Long getId() {
        return id;
    }

    public String getFoodCategoryName() {
        return foodCategoryName;
    }

    public String getFoodCategoryImg() {
        return foodCategoryImg;
    }

    public Collection<Ingredient> getIngredient() {
        return ingredient;
    }

    public Collection<Preference> getPreference() {
        return preference;
    }

    public FoodCategory(String foodCategoryName, String foodCategoryImg) {
        this.foodCategoryName = foodCategoryName;
        this.foodCategoryImg = foodCategoryImg;
    }

    public FoodCategory() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodCategory that = (FoodCategory) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
