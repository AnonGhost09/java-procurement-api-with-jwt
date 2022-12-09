package com.enigma.procurement.repositories;

import com.enigma.procurement.models.Reporting;
import com.enigma.procurement.models.Transaction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    List<Transaction> findAll(Specification spec);

    @Query("select e from Transaction e where year(e.dateTransaction) = year(current_date) and month(e.dateTransaction) = month(current_date)")
    List<Transaction> getAllByMonth();

}
