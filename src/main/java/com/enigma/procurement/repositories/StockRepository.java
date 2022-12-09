package com.enigma.procurement.repositories;

import com.enigma.procurement.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, String> {
}
