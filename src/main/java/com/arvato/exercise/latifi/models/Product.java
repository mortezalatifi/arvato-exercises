package com.arvato.exercise.latifi.models;

import java.math.BigDecimal;

public class Product {
    private String name;
    private String countryOfOrigin;
    private BigDecimal price;
    private boolean isFragile;
    private long timesPurchased;

    public Product(String name, String countryOfOrigin, BigDecimal price, boolean isFragile, long timesPurchased) {
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isFragile = isFragile;
        this.timesPurchased = timesPurchased;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public void setFragile(boolean fragile) {
        isFragile = fragile;
    }

    public long getTimesPurchased() {
        return timesPurchased;
    }

    public void setTimesPurchased(long timesPurchased) {
        this.timesPurchased = timesPurchased;
    }
}
