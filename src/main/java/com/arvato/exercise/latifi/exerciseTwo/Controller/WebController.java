package com.arvato.exercise.latifi.exerciseTwo.Controller;

import com.arvato.exercise.latifi.exerciseTwo.models.Product;
import com.arvato.exercise.latifi.exerciseTwo.models.ProductAnalyzeResponse;
import com.arvato.exercise.latifi.exerciseTwo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
public class WebController {

    @Autowired
    ProductService productService;

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
