package com.enigma.procurement.services;

import com.enigma.procurement.models.Category;
import com.enigma.procurement.models.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    List<Product> getAll();
}
