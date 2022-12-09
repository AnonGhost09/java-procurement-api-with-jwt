package com.enigma.procurement.services;

import com.enigma.procurement.models.Reporting;

import java.util.List;

public interface ReportingService {
    List<Reporting> getAllToday();
    List<Reporting> getAllMonth();

    List<Reporting> getAll();
}
