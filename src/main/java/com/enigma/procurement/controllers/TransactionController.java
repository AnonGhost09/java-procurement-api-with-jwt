package com.enigma.procurement.controllers;

import com.enigma.procurement.models.Product;
import com.enigma.procurement.models.Transaction;
import com.enigma.procurement.models.requests.ProductRequest;
import com.enigma.procurement.models.requests.TransactionRequest;
import com.enigma.procurement.models.responses.SuccessResponse;
import com.enigma.procurement.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity createTransaction(@RequestBody TransactionRequest transactionRequest) throws Exception {
        System.out.println("dedew");
        Transaction transaction = modelMapper.map(transactionRequest, Transaction.class);

        Transaction result = transactionService.create(transaction);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create Transaction",result));
    }
}
