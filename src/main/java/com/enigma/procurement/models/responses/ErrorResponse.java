package com.enigma.procurement.models.responses;

public class ErrorResponse extends CommonResponse{
    public ErrorResponse(String code, String message) {
        super.setCode(code);
        super.setMessage(message);
        super.setStatus("ERROR");
    }
}
