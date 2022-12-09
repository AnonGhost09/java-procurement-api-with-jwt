package com.enigma.procurement.services;

import com.enigma.procurement.models.requests.AdminRequest;

public interface AuthService {
    String login(AdminRequest adminRequest);
}
