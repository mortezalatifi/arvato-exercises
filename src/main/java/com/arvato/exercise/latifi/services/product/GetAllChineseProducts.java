package com.arvato.exercise.latifi.services.product;

import com.arvato.exercise.latifi.models.Product;

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
