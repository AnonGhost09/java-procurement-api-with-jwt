package com.enigma.procurement.models.requests;

import com.enigma.procurement.models.Product;


public class CategoryRequest {

    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
