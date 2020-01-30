package com.arvato.exercise.latifi.exerciseTwo.productStrategyPattern;

import com.arvato.exercise.latifi.exerciseTwo.models.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortProductByTimePurchased implements ProductStrategy, Comparator<Product> {

    @Override
    public int compare(Product a, Product b) {
        return a.getTimesPurchased() - b.getTimesPurchased();
    }

    @Override
    public ArrayList<Product> doOperation(ArrayList<Product> products) {
        Collections.sort(products, new SortProductByTimePurchased());
        return products;
    }
}
