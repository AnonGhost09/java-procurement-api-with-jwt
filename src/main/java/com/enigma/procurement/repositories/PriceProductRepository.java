package com.enigma.procurement.repositories;

import com.enigma.procurement.models.PriceProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceProductRepository extends JpaRepository<PriceProduct, String> {
}
