package com.enigma.procurement.services;

import com.enigma.procurement.models.Category;

import java.util.List;

public interface CategoryService {
    Category create(Category category);
    List<Category> getAll();
}
