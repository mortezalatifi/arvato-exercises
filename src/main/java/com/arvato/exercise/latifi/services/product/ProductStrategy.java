package com.arvato.exercise.latifi.services.product;

import com.arvato.exercise.latifi.models.Product;

import java.util.ArrayList;

public interface ProductStrategy {
    ArrayList<Product> doOperation(ArrayList<Product> products);

}
