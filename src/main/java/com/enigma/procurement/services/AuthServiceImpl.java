package com.enigma.procurement.services;

import com.enigma.procurement.exception.NotFoundException;
import com.enigma.procurement.exception.UnauthorizedException;
import com.enigma.procurement.models.Admin;
import com.enigma.procurement.models.requests.AdminRequest;
import com.enigma.procurement.repositories.AdminRepository;
import com.enigma.procurement.repositories.specifications.AuthSpec;
import com.enigma.procurement.utils.JwtUtil;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    private final JwtUtil jwtUtil;
    private AdminRepository adminRepository;


    public AuthServiceImpl(JwtUtil jwtUtil, AdminRepository adminRepository) {
        this.jwtUtil = jwtUtil;
        this.adminRepository = adminRepository;
    }
    @Transactional
    public String login(AdminRequest adminRequest) {
        try{
            Specification specification = new AuthSpec().getAdmin(adminRequest.getEmail());
            System.out.println(adminRequest.getEmail());;
            Admin admin = adminRepository.findByEmail(adminRequest.getEmail());

            if (admin == null) {
                throw new NotFoundException("Admin not found");
            }

            if (!admin.getPassword().equals(adminRequest.getPassword())) {
                throw new UnauthorizedException("Password salah");
            }

            String token = jwtUtil.generateToken(admin.toString());
            return token;
        }catch (UnauthorizedException e){
            throw new UnauthorizedException("Invalid user name or password");
        }
    }
}
