package com.enigma.procurement.controllers;

import com.enigma.procurement.constansts.UrlMappings;
import com.enigma.procurement.models.requests.AdminRequest;
import com.enigma.procurement.services.AuthServiceImpl;
import com.enigma.procurement.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlMappings.AUTH_URL)
public class AuthController {
    @Autowired
    private final AuthServiceImpl authService;

    @Autowired
    JwtUtil jwtUtil;

    public AuthController(AuthServiceImpl authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity authentication(@RequestBody AdminRequest adminRequest){
        System.out.println("ba");;
        String token = authService.login(adminRequest);
        return ResponseEntity.ok(token);
    }
}
