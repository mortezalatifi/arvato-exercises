package com.arvato.exercise.latifi.exerciseTwo.productStrategyPattern;

import com.arvato.exercise.latifi.exerciseTwo.models.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A concrete class of the ProductStrategyPattern that sort products list by times purchased
 * This is useful to get the most or the least favorite product while having
 * a sorted list for other uses.
 * This class implements both ProductStrategyPattern and the Comparator which
 * compares to values with its compare method.
 */
public class SortProductByTimePurchased implements ProductStrategy, Comparator<Product> {

    /**
     * This is the override compare method of the Comparator class which
     * compares two arguments for order
     * @param a This is argument one
     * @param b This is argument two
     * @return int This is the comparison result
     */
    @Override
    public int compare(Product a, Product b) {
        return a.getTimesPurchased() - b.getTimesPurchased();
    }

    /**
     * The override doOperation of the ProductStrategyPattern
     * @param products This is the list of products as method parameter
     * @return ArrayList This is the sorted product list by times purchased
     */
    @Override
    public ArrayList<Product> doOperation(ArrayList<Product> products) {
        Collections.sort(products, new SortProductByTimePurchased());
        return products;
    }
}
