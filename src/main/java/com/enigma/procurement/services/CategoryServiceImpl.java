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
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;

    public Category create(Category category){
        try {
            return repository.save(category);
        } catch (DataIntegrityViolationException e) {
            throw new EntityExistException("Category gagal dimasukan");
        }
    }

    public List<Category> getAll(){
        List result = repository.findAll();
        if (result.isEmpty()) {
            throw new NotFoundException("Category not found");
        }
        return result;
    }
}
