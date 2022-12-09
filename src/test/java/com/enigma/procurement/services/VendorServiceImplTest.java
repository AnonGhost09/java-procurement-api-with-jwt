package com.enigma.procurement.services;

import com.enigma.procurement.repositories.CategoryRepository;
import com.enigma.procurement.repositories.PriceProductRepository;
import com.enigma.procurement.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class VendorServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Mock
    ProductRepository mockProductRepository;

    @Mock
    CategoryRepository mockCategoryRepository;

    @Mock
    PriceProductRepository priceProductRepository;

    @Mock
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productService = new ProductServiceImpl(mockProductRepository,mockCategoryRepository);

    }

}
