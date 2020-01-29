package com.arvato.exercise.latifi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Product {
    @JsonProperty("ddat")
    private String name;
    private String countryOfOrigin;
    private BigDecimal price;
    private boolean isFragile;
    private int timesPurchased;

    public Product(String name, String countryOfOrigin, BigDecimal price, boolean isFragile, int timesPurchased) {
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

    public int getTimesPurchased() {
        return timesPurchased;
    }

    public void setTimesPurchased(int timesPurchased) {
        this.timesPurchased = timesPurchased;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", price=" + price +
                ", isFragile=" + isFragile +
                ", timesPurchased=" + timesPurchased +
                '}';
    }
}
