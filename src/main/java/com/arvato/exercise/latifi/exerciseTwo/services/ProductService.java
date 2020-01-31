package com.arvato.exercise.latifi.exerciseTwo.services;

import com.arvato.exercise.latifi.exerciseTwo.models.Product;
import com.arvato.exercise.latifi.exerciseTwo.productStrategyPattern.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * <h1>Product Service</h1>
 * The product service class that does the followings:
 *      - Get the most expensive product
 *      - Get the cheapest product
 *      - Get the most and least popular products
 *      - Get products by country
 *      - Checks if there are any fragile products in the list
 */

@Service
public class ProductService {

    /**
     * Gets the most expensive product using the sorted product list by price
     * @param products This is the list of products as method parameter
     * @return Product This is the most expensive product
     */
    public Product getMostExpensiveProduct(ArrayList<Product> products) {
        // Throwing exception if products is not valid
        if (products == null || products.size() <= 1)
            throw new IllegalArgumentException("Product list = null or with size < 1 not allowed!");

        // Getting the most expensive product
        ProductStrategyPatternContext productStrategyPatternContext = new ProductStrategyPatternContext(new SortProductByPrice());
        productStrategyPatternContext.executeStrategy(products);
        return products.get(products.size() - 1);
    }

    /**
     * Gets the cheapest product using the sorted product list by price
     * @param products This is the list of products as method parameter
     * @return Product This is the cheapest product
     */
    public Product getCheapestProduct(ArrayList<Product> products) {
        // Throwing exception if products is not valid
        if (products == null || products.size() <= 1)
            throw new IllegalArgumentException("Product list = null or with size < 1 not allowed!");

        // Getting the cheapest product
        ProductStrategyPatternContext productStrategyPatternContext = new ProductStrategyPatternContext(new SortProductByPrice());
        productStrategyPatternContext.executeStrategy(products);
        return products.get(0);
    }

    /**
     * Gets the most popular product using the sorted product list by times purchased
     * @param products This is the list of products as method parameter
     * @return Product This is the most popular product
     */
    public Product getMostPopularProduct(ArrayList<Product> products) {
        // Throwing exception if products is not valid
        if (products == null || products.size() <= 1)
            throw new IllegalArgumentException("Product list = null or with size < 1 not allowed!");

        // Getting the most popular product
        ProductStrategyPatternContext productStrategyPatternContext = new ProductStrategyPatternContext(new SortProductByTimePurchased());
        productStrategyPatternContext.executeStrategy(products);
        return products.get(products.size() - 1);
    }

    /**
     * Gets the least popular product using the sorted product list by times purchased
     * @param products This is the list of products as method parameter
     * @return Product This is the least popular product
     */
    public ArrayList<Product> getProductsByCountry(ArrayList<Product> products, String country) {
        // Throwing exception if products is not valid
        if (products == null)
            throw new IllegalArgumentException("Product list = null not allowed!");

        // Getting the products by country
        ProductStrategyPatternContext productStrategyPatternContext;
        switch (country) {
            case "Germany":
                productStrategyPatternContext = new ProductStrategyPatternContext(new GetAllGermanProducts());
                return productStrategyPatternContext.executeStrategy(products);
            case "China":
                productStrategyPatternContext = new ProductStrategyPatternContext(new GetAllChineseProducts());
                return productStrategyPatternContext.executeStrategy(products);
            default:
                return null;
        }
    }

    /**
     * Gets the list of fragile products. If the list is not null returns true, else false
     * @param products This is the list of products as method parameter
     * @return boolean This is the true or false
     */
    public boolean containsFragile(ArrayList<Product> products) {
        // Throwing exception if products is not valid
        if (products == null)
            throw new IllegalArgumentException("Product list = null not allowed!");

        // Getting the fragile products
        ProductStrategyPatternContext productStrategyPatternContext = new ProductStrategyPatternContext(new GetAllFragileProducts());
        return productStrategyPatternContext.executeStrategy(products).size() > 0 ? true : false;
    }
}
