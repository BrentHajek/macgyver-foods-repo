package com.macgyverfoods.pickyeater.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class FoodCategory {

    @Id
    @GeneratedValue
    private Long id;

    private String foodCategoryName;
    private String foodCategoryImg;

    @OneToOne
    private Ingredient ingredient;

    public Long getId() {
        return id;
    }

    public String getFoodCategoryName() {
        return foodCategoryName;
    }

    public String getFoodCategoryImg() {
        return foodCategoryImg;
    }

    public Ingredient getIngredient() {
        return ingredient;
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
