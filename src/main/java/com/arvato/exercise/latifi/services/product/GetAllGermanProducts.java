package com.arvato.exercise.latifi.services.product;

import com.arvato.exercise.latifi.models.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class GetAllGermanProducts implements ProductStrategy {

    @Override
    public ArrayList<Product> doOperation(ArrayList<Product> products) {
        return (ArrayList<Product>) products.stream()
                .filter(product -> product.getCountryOfOrigin().equals("DE"))
                .collect(Collectors.toList());
    }
}
