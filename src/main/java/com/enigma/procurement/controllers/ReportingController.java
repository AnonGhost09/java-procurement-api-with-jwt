package com.enigma.procurement.controllers;

import com.enigma.procurement.models.Product;
import com.enigma.procurement.models.Reporting;
import com.enigma.procurement.models.responses.DownloadResponse;
import com.enigma.procurement.models.responses.SuccessResponse;
import com.enigma.procurement.services.ReportingService;
import com.enigma.procurement.utils.ToCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reporting")
public class ReportingController {
    @Autowired
    private ReportingService reportingService;


    @GetMapping(params = {"time","csv"})
    public ResponseEntity getAllReporting(@RequestParam("time") String time,
                                          @RequestParam(value = "csv", defaultValue = "reporting") String csvName) throws Exception {
        List<Reporting> result = null;
        if(time.equals("today")){
            System.out.println("hadir");
            result = reportingService.getAllToday();
        }else if(time.equals("month")){
            System.out.println("hadir mont");
            result = reportingService.getAllMonth();
        }else{
            System.out.println("hadir get");
            result = reportingService.getAll();
        }

        ToCsv toCsv = new ToCsv("src/main/java/com/enigma/procurement/assets/"+csvName+".csv");
        String path = toCsv.getPath();
        toCsv.writeData(result);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new DownloadResponse<>( "Success get all reporting",path,result));
    }
}
