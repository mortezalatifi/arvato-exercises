package com.arvato.exercise.latifi.Controller;

import com.arvato.exercise.latifi.models.Product;
import com.arvato.exercise.latifi.services.product.GetAllGermanProducts;
import com.arvato.exercise.latifi.services.product.ProductContext;
import com.arvato.exercise.latifi.services.product.ProductService;
import com.arvato.exercise.latifi.services.product.SortProductByPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class WebController {

    @Autowired
    ProductService productService;

    @PostMapping(path = "/text/analyze", consumes = "application/json", produces = "application/json")
    public void analyzeProducts(@RequestBody ArrayList<Product> products) {
        System.out.println("Befor operation: ");
        System.out.println(products);

        System.out.println(productService.getCheapestProduct(products));
        System.out.println(productService.getMostExpensiveProduct(products));

        System.out.println(productService.getProductsByCountry(products, "Germany"));
    }
}
