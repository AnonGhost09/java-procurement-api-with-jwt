package com.enigma.procurement.controllers;

import com.enigma.procurement.constansts.UrlMappings;
import com.enigma.procurement.models.Admin;
import com.enigma.procurement.models.Category;
import com.enigma.procurement.models.requests.AdminRequest;
import com.enigma.procurement.models.responses.SuccessResponse;
import com.enigma.procurement.services.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMappings.ADMIN_URL)
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity authentication(@RequestBody AdminRequest adminRequest){
        Admin newAdmin = modelMapper.map(adminRequest,Admin.class);

        Admin result = adminService.create(newAdmin);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create admin",result));
    }

    @GetMapping
    public ResponseEntity logout(){
        List<Admin> result= adminService.getAll();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success get all Admin",result));
    }
}
