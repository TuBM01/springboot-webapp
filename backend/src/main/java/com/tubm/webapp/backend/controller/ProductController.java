package com.tubm.webapp.backend.controller;

import com.tubm.webapp.backend.model.Product;
import com.tubm.webapp.backend.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class ProductController {

    @Autowired
    private ProductService prodService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return prodService.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) {
        return prodService.getProductById(id);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        prodService.addProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id) {
        prodService.deleteProduct(id);
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody Product product) {
        prodService.updateProduct(id, product);
    }
}
