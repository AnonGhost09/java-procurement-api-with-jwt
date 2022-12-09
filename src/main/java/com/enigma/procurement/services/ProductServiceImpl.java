package com.enigma.procurement.services;

import com.enigma.procurement.exception.EntityExistException;
import com.enigma.procurement.exception.NotFoundException;
import com.enigma.procurement.models.Category;
import com.enigma.procurement.models.Product;
import com.enigma.procurement.repositories.CategoryRepository;
import com.enigma.procurement.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository repository;
    private CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    public Product create(Product product){
        try {
            Optional<Category> category = categoryRepository.findById(product.getCategory().getCategoryId());
            if(category.isEmpty()){
                throw new NotFoundException("Data category tidak ditemukan");
            }
            return repository.save(product);
        } catch (Exception e) {
            throw new RuntimeException("Data gagal dibuat");
        }

    }

    public List<Product> getAll(){
        List result = repository.findAll();
        if (result.isEmpty()) {
            throw new NotFoundException("Product not found");
        }
        return result;
    }
}
