package com.arvato.exercise.latifi.exerciseTwo.productStrategyPattern;

import com.arvato.exercise.latifi.exerciseTwo.models.Product;

import java.util.ArrayList;

/**
 * The interface of the strategy pattern
 */

public interface ProductStrategy {
    ArrayList<Product> doOperation(ArrayList<Product> products);
}
