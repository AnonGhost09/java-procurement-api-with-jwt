package com.enigma.procurement.services;

import com.enigma.procurement.exception.NotFoundException;
import com.enigma.procurement.models.Stock;
import com.enigma.procurement.models.Transaction;
import com.enigma.procurement.repositories.StockRepository;
import com.enigma.procurement.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    private StockRepository stockRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository, StockRepository stockRepository) {
        this.transactionRepository = transactionRepository;
        this.stockRepository = stockRepository;
    }

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
}
