package com.enigma.procurement.services;

import com.enigma.procurement.models.Category;
import com.enigma.procurement.models.Product;
import com.enigma.procurement.repositories.CategoryRepository;
import com.enigma.procurement.repositories.ProductRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Mock
    ProductRepository mockProductRepository;

    @Mock
    CategoryRepository mockCategoryRepository;

    @BeforeEach
    void setUp() {
        productService = new ProductServiceImpl(mockProductRepository,mockCategoryRepository);
    }

    @Test
    void itShould_ReturnProduct_When_ProductServiceCreateProduct() throws Exception{
        Category dummyCategory = new Category();

        dummyCategory.setCategoryId("1");
        dummyCategory.setCategoryName("BAJU ANAK ANAK");

        Product dummyProduct = new Product();

        dummyProduct.setProductId("1");
        dummyProduct.setProductName("product 1");


        dummyProduct.setCategory(dummyCategory);

        List<Product> productsListDummy = new ArrayList<>();
        productsListDummy.add(dummyProduct);

        when(mockProductRepository.findAll()).thenReturn(productsListDummy);
        List<Product> actualProduct = productService.getAll();

        Assertions.assertEquals(1, actualProduct.size());
    }

}