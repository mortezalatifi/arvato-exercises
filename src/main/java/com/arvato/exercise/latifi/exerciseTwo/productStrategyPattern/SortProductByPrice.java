package com.arvato.exercise.latifi.exerciseTwo.productStrategyPattern;

import com.arvato.exercise.latifi.exerciseTwo.models.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortProductByPrice implements ProductStrategy, Comparator<Product> {

    @Override
    public int compare(Product a, Product b) {
        return a.getPrice().compareTo(b.getPrice());
    }

    @Override
    public ArrayList<Product> doOperation(ArrayList<Product> products) {
        Collections.sort(products, new SortProductByPrice());
        return products;
    }
}
