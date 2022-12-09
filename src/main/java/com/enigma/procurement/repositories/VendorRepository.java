package com.enigma.procurement.repositories;

import com.enigma.procurement.models.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, String> {
}
