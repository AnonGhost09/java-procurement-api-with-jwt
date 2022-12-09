package com.enigma.procurement.controllers;

import com.enigma.procurement.models.Product;
import com.enigma.procurement.models.Reporting;
import com.enigma.procurement.models.responses.SuccessResponse;
import com.enigma.procurement.services.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reporting")
public class ReportingController {
    @Autowired
    private ReportingService reportingService;


    @GetMapping
    public ResponseEntity getAllReportingToday() throws Exception {

        List<Reporting> result= reportingService.getAllToday();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success get all reporting today",result));
    }
}
