package com.enigma.procurement.services;

import com.enigma.procurement.exception.NotFoundException;
import com.enigma.procurement.models.*;
import com.enigma.procurement.repositories.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VendorServiceImplTest {

    @Autowired
    private VendorService vendorService;

    @Mock
    StockRepository stockRepository;

    @Mock
    ProductRepository productRepository;

    @Mock
    PriceProductRepository priceProductRepository;

    @Mock
    VendorRepository vendorRepository;

    @BeforeEach
    void setUp() {
        vendorService = new VendorServiceImpl(vendorRepository,stockRepository,priceProductRepository,productRepository);
    }

    @Test
    void itShould_ReturnStock_When_VendorServiceCreateStock() throws Exception{
        Category dummyCategory = new Category();

//        dummyCategory.setCategoryId("1");
        dummyCategory.setCategoryName("BAJU ANAK ANAK");

        Product dummyProduct = new Product();

//        dummyProduct.setProductId("1");
        dummyProduct.setProductName("product 1");

        when(productRepository.findById(any())).thenReturn(Optional.of(dummyProduct));

        Vendor dummyVendor = new Vendor();
        dummyVendor.setVendorName("VENDOR A");

        when(vendorRepository.save(any())).thenReturn(dummyVendor);

        PriceProduct dummyPriceProduct = new PriceProduct();
        dummyPriceProduct.setPrice(155000D);

        when(priceProductRepository.save(any())).thenReturn(dummyPriceProduct);

        Stock dummyStock = new Stock();

        dummyStock.setProduct(dummyProduct);
        dummyStock.setVendor(dummyVendor);
        dummyStock.setPriceProduct(dummyPriceProduct);

        when(stockRepository.save(any())).thenReturn(dummyStock);

        Stock stockActual = vendorService.create(dummyStock);
        Assertions.assertEquals(dummyStock.getStockId(),stockActual.getStockId());
    }

    @Test
    void itShould_ThrowException_When_VendorServiceCreateError() throws Exception{
        Product dummyProduct = new Product();

        dummyProduct.setProductId("1");
        dummyProduct.setProductName("product 1");

        Stock dummyStock = new Stock();
        dummyStock.setProduct(dummyProduct);

        when(productRepository.findById(any())).thenThrow(NotFoundException.class);

        Assertions.assertThrows(RuntimeException.class,() ->vendorService.create(dummyStock));
    }


    @Test
    void itShould_ReturnListVendor_When_VendorServiceGetAllVendor() throws Exception{
        Vendor dummyVendor = new Vendor();
        dummyVendor.setVendorName("VENDOR A");

        List<Vendor> vendorsListDummy = new ArrayList<>();
        vendorsListDummy.add(dummyVendor);

        when(vendorRepository.findAll()).thenReturn(vendorsListDummy);
        List<Vendor> actualVendor = vendorService.getAll();

        Assertions.assertEquals(1, actualVendor.size());
    }

    @Test
    void itShould_ThrowNotFoundException_When_VendorServiceGetAllError() throws Exception{
        when(vendorRepository.findAll()).thenThrow(NotFoundException.class);
        Assertions.assertThrows(RuntimeException.class,() ->vendorService.getAll());
    }


    @Test
    void itShould_ReturnListVendor_When_VendorServiceUpdateVendor() throws Exception{
        Vendor dummyVendor = new Vendor();
        dummyVendor.setVendorName("VENDOR A");

        List<Vendor> vendorsListDummy = new ArrayList<>();
        vendorsListDummy.add(dummyVendor);

        when(vendorRepository.findAll()).thenReturn(vendorsListDummy);
        List<Vendor> actualVendor = vendorService.getAll();

        Assertions.assertEquals(1, actualVendor.size());
    }

    @Test
    void itShould_ThrowNotFoundException_When_VendorServiceUpdateError() throws Exception{
        Stock stock = new Stock();
        stock.setStockId("1");
        when(stockRepository.findById(anyString())).thenThrow(NotFoundException.class);
        Assertions.assertThrows(RuntimeException.class,() -> vendorService.update(stock));
    }



}
