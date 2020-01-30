package com.arvato.exercise.latifi.exerciseTwo.productStrategyPattern;

import com.arvato.exercise.latifi.exerciseTwo.models.Product;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GetAllChineseProducts implements ProductStrategy {

    @Override
    public ArrayList<Product> doOperation(ArrayList<Product> products) {
        return (ArrayList<Product>) products.stream()
                .filter(product -> product.getCountryOfOrigin().equals("CN"))
                .collect(Collectors.toList());
    }
}
