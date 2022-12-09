package com.enigma.procurement.services;

import com.enigma.procurement.models.Stock;
import com.enigma.procurement.models.Vendor;

import java.util.List;

public interface VendorService {
    List<Vendor> getAll();
    Stock create(Stock stock);
    Stock update(Stock stock);
}
