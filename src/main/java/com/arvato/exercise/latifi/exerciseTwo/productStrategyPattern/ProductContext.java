package com.arvato.exercise.latifi.exerciseTwo.productStrategyPattern;

import com.arvato.exercise.latifi.exerciseTwo.models.Product;

import java.util.ArrayList;

public class ProductContext {

    private ProductStrategy productStrategy;

    public ProductContext(ProductStrategy productStrategy) {
        this.productStrategy = productStrategy;
    }

    public ArrayList<Product> executeStrategy(ArrayList<Product> products) {
        return productStrategy.doOperation(products);
    }
}
