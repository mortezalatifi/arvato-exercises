package com.arvato.exercise.latifi.exerciseTwo.productStrategyPattern;

import com.arvato.exercise.latifi.exerciseTwo.models.Product;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * A concrete class of the ProductStrategyPattern that gets All the german products
 */
public class GetAllGermanProducts implements ProductStrategy {

    /**
     * This methods get a list of products and filters the list by the country
     * @param products This is the list of products as method parameter
     * @return ArrayList This returns the filtered list
     */
    @Override
    public ArrayList<Product> doOperation(ArrayList<Product> products) {
        return (ArrayList<Product>) products.stream()
                .filter(product -> product.getCountryOfOrigin().equals("DE"))
                .collect(Collectors.toList());
    }
}
