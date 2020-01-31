package com.arvato.exercise.latifi.exerciseTwo.productStrategyPattern;

import com.arvato.exercise.latifi.exerciseTwo.models.Product;

import java.util.ArrayList;

/**
 * The ProductStrategy context class
 */
public class ProductStrategyPatternContext {

    private ProductStrategy productStrategy;

    public ProductStrategyPatternContext(ProductStrategy productStrategy) {
        this.productStrategy = productStrategy;
    }

    /**
     * This executes the desired operation on the list of products
     * @param products This is the list of products as method parameter
     * @return ArrayList This is the operation result
     */
    public ArrayList<Product> executeStrategy(ArrayList<Product> products) {
        return productStrategy.doOperation(products);
    }
}
