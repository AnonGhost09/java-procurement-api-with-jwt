package com.enigma.procurement.services;

import com.enigma.procurement.exception.NotFoundException;
import com.enigma.procurement.models.Stock;
import com.enigma.procurement.models.Transaction;
import com.enigma.procurement.repositories.StockRepository;
import com.enigma.procurement.repositories.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    private StockRepository stockRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository, StockRepository stockRepository) {
        this.transactionRepository = transactionRepository;
        this.stockRepository = stockRepository;
    }

    @Transactional
    @Override
    public Transaction create(Transaction transaction) {

        try {

            Optional<Stock> stock = stockRepository.findById(transaction.getStock().getStockId());

            if (stock.isEmpty()) {
                throw new NotFoundException("Data stock tidak ada");
            }

            transaction.setStock(stock.get());

            Transaction transactionResult = transactionRepository.save(transaction);

            return transactionResult;
        }catch (Exception e){
            throw new RuntimeException("Data gagal dimasukan");
        }
    }

    @Transactional
    @Override
    public List<Transaction> getAllTransaction() {
        List result = transactionRepository.findAll();
        if (result.isEmpty()) {
            throw new NotFoundException("Transaction not found");
        }
        return result;
    }
}
