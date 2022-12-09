package com.enigma.procurement.models.requests;

import com.enigma.procurement.models.PriceProduct;
import com.enigma.procurement.models.Product;
import com.enigma.procurement.models.Vendor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

public class StockRequest {
    private Product product;

    private Vendor vendor;

    private PriceProduct priceProduct;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public PriceProduct getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(PriceProduct priceProduct) {
        this.priceProduct = priceProduct;
    }
}
