package com.enigma.procurement.controllers;

import com.enigma.procurement.models.Product;
import com.enigma.procurement.models.Stock;
import com.enigma.procurement.models.Vendor;
import com.enigma.procurement.models.requests.PriceRequest;
import com.enigma.procurement.models.requests.StockRequest;
import com.enigma.procurement.models.responses.SuccessResponse;
import com.enigma.procurement.services.VendorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private VendorService vendorService;

    @GetMapping
    public ResponseEntity getAllVendor() throws Exception {

        List<Vendor> result= vendorService.getAll();

        return ResponseEntity.status(HttpStatus.OK)
                .body(new SuccessResponse<>( "Success get all vendors",result));
    }

    @PostMapping
    public ResponseEntity createVendor(@RequestBody StockRequest stockRequest) throws Exception {

        Stock newStock = modelMapper.map(stockRequest, Stock.class);

        Stock result  = vendorService.create(newStock);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create vendor",result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateVendor(@RequestBody PriceRequest priceRequest, @PathVariable String id) throws Exception {

        Stock newStock = modelMapper.map(priceRequest, Stock.class);
        newStock.setStockId(id);

        Stock result  = vendorService.update(newStock);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success update vendor price",result));
    }
}
