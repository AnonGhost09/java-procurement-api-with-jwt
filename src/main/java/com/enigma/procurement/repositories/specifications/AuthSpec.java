package com.enigma.procurement.repositories.specifications;

import com.enigma.procurement.models.Admin;
import com.enigma.procurement.models.Transaction;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class AuthSpec {
    public Specification<Admin> getAdmin(String email){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("email"), email);
    }

}
