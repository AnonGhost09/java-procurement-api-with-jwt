package com.enigma.procurement.repositories;

import com.enigma.procurement.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
