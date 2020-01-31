package com.arvato.exercise.latifi.exerciseTwo.controller;

import com.arvato.exercise.latifi.exerciseTwo.models.Product;
import com.arvato.exercise.latifi.exerciseTwo.models.ProductAnalyzeResponse;
import com.arvato.exercise.latifi.exerciseTwo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * <h1>Wob controller</h1>
 * A Rest Controller API for the products which uses the ProductService class
 */
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * The analyzeProducts method gets a list of products and returns the following result as JSON:
     *      - The most expensive product
     *      - The cheapest product
     *      - Best selling product
     *      - The names of all german products
     *      - The names of all chinese products
     *      - If the list contains one or more fragile products
     * @param products
     * @return a ProductAnalyzeResponse object
     */
    @PostMapping(path = "/text/analyze", consumes = "application/json", produces = "application/json")
    public ProductAnalyzeResponse analyzeProducts(@RequestBody ArrayList<Product> products) {
        return new ProductAnalyzeResponse(
                productService.getMostExpensiveProduct(products).getName(),
                productService.getCheapestProduct(products).getName(),
                productService.getMostPopularProduct(products).getName(),
                productService.getProductsByCountry(products, "Germany").stream()
                .map(Product::getName)
                .collect(Collectors.toCollection(ArrayList::new)),
                productService.getProductsByCountry(products, "China").stream()
                        .map(Product::getName)
                        .collect(Collectors.toCollection(ArrayList::new)),
                productService.containsFragile(products)
        );
    }
}
