package com.enigma.procurement.services;

import com.enigma.procurement.models.Admin;
import com.enigma.procurement.models.Category;

import java.util.List;

public interface AdminService {
    Admin create(Admin admin);
    List<Admin> getAll();
}
