package com.arvato.exercise.latifi.exerciseTwo.productStrategyPattern;

import com.arvato.exercise.latifi.exerciseTwo.models.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A concrete class of the ProductStrategyPattern that sort products list by price
 * This is useful to get the most expensive or the cheapest product while having
 * a sorted list for other uses.
 * This class implements both ProductStrategyPattern and the Comparator which
 * compares to values with its compare method.
 */
public class SortProductByPrice implements ProductStrategy, Comparator<Product> {

    /**
     * This is the override compare method of the Comparator class which
     * compares two arguments for order
     * @param a This is argument one
     * @param b This is argument two
     * @return int This is the comparison result
     */
    @Override
    public int compare(Product a, Product b) {
        return a.getPrice().compareTo(b.getPrice());
    }

    /**
     * The override doOperation of the ProductStrategyPattern
     * @param products This is the list of products as method parameter
     * @return ArrayList This is the sorted product list by price
     */
    @Override
    public ArrayList<Product> doOperation(ArrayList<Product> products) {
        Collections.sort(products, new SortProductByPrice());
        return products;
    }
}
