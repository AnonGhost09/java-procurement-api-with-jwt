package com.enigma.procurement.repositories;

import com.enigma.procurement.models.Admin;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, String> {
    Admin findAll(Specification specification);

    @Query("SELECT a FROM Admin a WHERE a.email = ?1")
    Admin findByEmail(String email);
}
