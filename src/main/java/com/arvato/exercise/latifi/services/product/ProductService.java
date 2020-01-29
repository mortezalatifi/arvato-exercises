package com.arvato.exercise.latifi.services.product;

import com.arvato.exercise.latifi.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    public Product getMostExpensiveProduct(ArrayList<Product> products) {
        ProductContext productContext = new ProductContext(new SortProductByPrice());
        productContext.executeStrategy(products);
        return products.get(products.size() - 1);
    }

    public Product getCheapestProduct(ArrayList<Product> products) {
        ProductContext productContext = new ProductContext(new SortProductByPrice());
        productContext.executeStrategy(products);
        return products.get(0);
    }

    public ArrayList<Product> getProductsByCountry(ArrayList<Product> products, String country) {
        ProductContext productContext;
        switch (country) {
            case "Germany":
                productContext = new ProductContext(new GetAllGermanProducts());
                return productContext.executeStrategy(products);
            case "China":
                productContext = new ProductContext(new GetAllChineseProducts());
                return productContext.executeStrategy(products);
            default:
                return null;
        }
    }
}