package com.enigma.procurement.models.requests;

import com.enigma.procurement.models.Category;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

public class ProductRequest {
    private String productName;

    private Category categoryId;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }
}
