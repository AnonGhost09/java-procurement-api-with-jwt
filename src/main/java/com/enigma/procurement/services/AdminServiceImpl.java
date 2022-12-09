package com.enigma.procurement.services;

import com.enigma.procurement.exception.EntityExistException;
import com.enigma.procurement.exception.NotFoundException;
import com.enigma.procurement.models.Admin;
import com.enigma.procurement.models.Category;
import com.enigma.procurement.repositories.AdminRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    private AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Transactional
    public Admin create(Admin admin){
        try {
            return adminRepository.save(admin);
        } catch (DataIntegrityViolationException e) {
            throw new EntityExistException("Admin gagal dimasukan");
        }
    }

    @Transactional
    public List<Admin> getAll(){
        List result = adminRepository.findAll();
        if (result.isEmpty()) {
            throw new NotFoundException("Admin not found");
        }
        return result;
    }
}
