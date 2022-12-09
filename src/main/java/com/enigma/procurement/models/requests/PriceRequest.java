package com.enigma.procurement.models.requests;

import com.enigma.procurement.models.PriceProduct;

import javax.persistence.Column;

public class PriceRequest {
    private PriceProduct priceProduct;

    public PriceProduct getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(PriceProduct priceProduct) {
        this.priceProduct = priceProduct;
    }
}
