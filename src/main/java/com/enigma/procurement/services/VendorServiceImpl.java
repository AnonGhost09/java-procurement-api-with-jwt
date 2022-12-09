package com.enigma.procurement.services;

import com.enigma.procurement.exception.EntityExistException;
import com.enigma.procurement.exception.NotFoundException;
import com.enigma.procurement.models.PriceProduct;
import com.enigma.procurement.models.Product;
import com.enigma.procurement.models.Stock;
import com.enigma.procurement.models.Vendor;
import com.enigma.procurement.repositories.PriceProductRepository;
import com.enigma.procurement.repositories.ProductRepository;
import com.enigma.procurement.repositories.StockRepository;
import com.enigma.procurement.repositories.VendorRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService {
    private VendorRepository vendorRepository;
    private StockRepository stockRepository;
    private PriceProductRepository priceProductRepository;
    private ProductRepository productRepository;

    public VendorServiceImpl(VendorRepository vendorRepository, StockRepository stockRepository, PriceProductRepository priceProductRepository, ProductRepository productRepository) {
        this.vendorRepository = vendorRepository;
        this.stockRepository = stockRepository;
        this.priceProductRepository = priceProductRepository;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public List<Vendor> getAll(){
        List result = vendorRepository.findAll();
        if (result.isEmpty()) {
            throw new NotFoundException("Vendor not found");
        }
        return result;
    }

    @Transactional
    public Stock create(Stock stock){
        try {

            Optional<Product> product = productRepository.findById(stock.getProduct().getProductId());

            if(product.isEmpty()){
                throw new NotFoundException("Data product tidak ada");
            }

            Vendor vendorResult = vendorRepository.save(stock.getVendor());
            PriceProduct priceProduct = priceProductRepository.save(stock.getPriceProduct());

            stock.setProduct(product.get());
            stock.setVendor(vendorResult);
            stock.setPriceProduct(priceProduct);

            Stock stockResult = stockRepository.save(stock);

            return stockResult;

        } catch (Exception e) {
            throw new EntityExistException("Vendor gagal dimasukan");
        }
    }

    @Transactional
    @Override
    public Stock update(Stock stock) {
        try {
            Optional<Stock> stockResult = stockRepository.findById(stock.getStockId());

            if (stockResult.isEmpty()) {
                throw new NotFoundException("Data stock tidak tersedia");
            }

            stockResult.get().getPriceProduct().setPrice(stock.getPriceProduct().getPrice());
            Stock result = stockRepository.save(stockResult.get());
            return result;
        }
        catch (Exception e){
            throw new RuntimeException("Data gagal di update");
        }
    }
}
