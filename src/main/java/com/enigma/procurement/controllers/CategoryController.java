package com.enigma.procurement.controllers;

import com.enigma.procurement.constansts.UrlMappings;
import com.enigma.procurement.models.Category;
import com.enigma.procurement.models.requests.CategoryRequest;
import com.enigma.procurement.models.responses.SuccessResponse;
import com.enigma.procurement.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMappings.CATEGORY_URL)
public class CategoryController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity createCategory(@RequestBody CategoryRequest categoryRequest) throws Exception {
        Category newCategory = modelMapper.map(categoryRequest, Category.class);

        Category result = categoryService.create(newCategory);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create category",result));
    }

    @GetMapping
    public ResponseEntity getAllCategory() throws Exception {

        List<Category> result= categoryService.getAll();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success get all categories",result));
    }

}
