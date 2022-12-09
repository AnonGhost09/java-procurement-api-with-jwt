package com.enigma.procurement.services;

import com.enigma.procurement.models.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction create(Transaction transaction);
    List<Transaction> getAllTransaction();
}
