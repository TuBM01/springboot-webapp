package com.tubm.webapp.backend.service;

import java.util.List;
import java.util.ArrayList;

import com.tubm.webapp.backend.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1, "Product 1", 100.00));
        products.add(new Product(2, "Product 2", 200.00));
        products.add(new Product(3, "Product 3", 300.00));
    }

    public List<Product> getProducts() {
        return products;
    }
}
