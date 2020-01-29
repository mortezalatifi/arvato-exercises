package com.arvato.exercise.latifi.Controller;

import com.arvato.exercise.latifi.models.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebController {
    @PostMapping(path = "/text/analyze", consumes = "application/json", produces = "application/json")
    public void analyzeProducts(@RequestBody List<Product> products) {
        System.out.println(products);
    }
}
