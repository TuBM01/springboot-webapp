package com.tubm.webapp.backend.controller;

import com.tubm.webapp.backend.model.Product;

import java.util.List;

import com.tubm.webapp.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService prodService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return prodService.getProducts();
    }
}
