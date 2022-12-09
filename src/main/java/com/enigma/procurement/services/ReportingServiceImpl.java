package com.enigma.procurement.services;

import com.enigma.procurement.models.Reporting;
import com.enigma.procurement.models.Transaction;
import com.enigma.procurement.repositories.TransactionRepository;
import com.enigma.procurement.repositories.specifications.ReportingSpec;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportingServiceImpl implements ReportingService {

    private TransactionRepository transactionRepository;

    public ReportingServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Reporting> getAllToday() {
        Specification spec = new ReportingSpec().getAllDateToday();
        List<Transaction> transactions = transactionRepository.findAll(spec);

        return null;
    }

    @Override
    public List<Reporting> getAllMonth() {
        return null;
    }
}
