package com.arvato.exercise.latifi.exerciseTwo.models;

import java.util.ArrayList;

public class ProductAnalyzeResponse {
    private String mostExpensiveProduct;
    private String cheapestProduct;
    private String mostPopularProduct;
    private ArrayList<String> germanProducts;
    private ArrayList<String> chineseProducts;
    private boolean containsFragileProducts;

    public ProductAnalyzeResponse(String mostExpensiveProduct, String cheapestProduct, String mostPopularProduct, ArrayList<String> germanProducts, ArrayList<String> chineseProducts, boolean containsFragileProducts) {
        this.mostExpensiveProduct = mostExpensiveProduct;
        this.cheapestProduct = cheapestProduct;
        this.mostPopularProduct = mostPopularProduct;
        this.germanProducts = germanProducts;
        this.chineseProducts = chineseProducts;
        this.containsFragileProducts = containsFragileProducts;
    }

    public String getMostExpensiveProduct() {
        return mostExpensiveProduct;
    }

    public void setMostExpensiveProduct(String mostExpensiveProduct) {
        this.mostExpensiveProduct = mostExpensiveProduct;
    }

    public String getCheapestProduct() {
        return cheapestProduct;
    }

    public void setCheapestProduct(String cheapestProduct) {
        this.cheapestProduct = cheapestProduct;
    }

    public String getMostPopularProduct() {
        return mostPopularProduct;
    }

    public void setMostPopularProduct(String mostPopularProduct) {
        this.mostPopularProduct = mostPopularProduct;
    }

    public ArrayList<String> getGermanProducts() {
        return germanProducts;
    }

    public void setGermanProducts(ArrayList<String> germanProducts) {
        this.germanProducts = germanProducts;
    }

    public ArrayList<String> getChineseProducts() {
        return chineseProducts;
    }

    public void setChineseProducts(ArrayList<String> chineseProducts) {
        this.chineseProducts = chineseProducts;
    }

    public boolean isContainsFragileProducts() {
        return containsFragileProducts;
    }

    public void setContainsFragileProducts(boolean containsFragileProducts) {
        this.containsFragileProducts = containsFragileProducts;
    }
}
