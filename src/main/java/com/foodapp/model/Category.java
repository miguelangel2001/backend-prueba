package com.foodapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {

    @Id
    private Integer categoryId;
    private String categoryName;

    // ====================
    // Getters y Setters
    // ====================

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
