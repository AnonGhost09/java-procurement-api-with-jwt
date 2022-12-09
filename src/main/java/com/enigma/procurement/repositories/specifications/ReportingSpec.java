package com.enigma.procurement.repositories.specifications;

import com.enigma.procurement.models.Transaction;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalTime;
import java.util.Date;

public class ReportingSpec {
    public Specification<Transaction> getAllDateMonth(){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.between(root.get("dateTransaction"),new Date("2022-12-09"),new Date("2022-12-11"));
    }

    public Specification<Transaction> getAllDateToday(){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("dateTransaction"), new Date());
    }
}