package com.enigma.procurement.services;

import com.enigma.procurement.exception.EntityExistException;
import com.enigma.procurement.models.Category;
import com.enigma.procurement.models.PriceProduct;
import com.enigma.procurement.repositories.PriceProductRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class PriceProductServiceImpl implements PriceProductService{

    private PriceProductRepository priceProductRepository;

    public PriceProductServiceImpl(PriceProductRepository priceProductRepository) {
        this.priceProductRepository = priceProductRepository;
    }

    public PriceProduct create(PriceProduct priceProduct){
        try {
            return priceProductRepository.save(priceProduct);
        } catch (DataIntegrityViolationException e) {
            throw new EntityExistException("Price gagal dimasukan");
        }
    }

}
