package com.enigma.procurement.controllers;

import com.enigma.procurement.constansts.UrlMappings;
import com.enigma.procurement.models.Category;
import com.enigma.procurement.models.Product;
import com.enigma.procurement.models.requests.CategoryRequest;
import com.enigma.procurement.models.requests.ProductRequest;
import com.enigma.procurement.models.responses.SuccessResponse;
import com.enigma.procurement.services.CategoryService;
import com.enigma.procurement.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMappings.PRODUCT_URL)
public class ProductController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity createProduct(@RequestBody ProductRequest productRequest) throws Exception {

        Product product = modelMapper.map(productRequest, Product.class);

        Product result = productService.create(product);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create category",result));
    }

    @GetMapping
    public ResponseEntity getAllProduct() throws Exception {

        List<Product> result= productService.getAll();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success get all categories",result));
    }
}
