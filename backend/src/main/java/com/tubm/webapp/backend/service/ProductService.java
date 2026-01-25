package com.tubm.webapp.backend.service;

import java.util.List;

import com.tubm.webapp.backend.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.tubm.webapp.backend.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void addProduct(Product product) {
        repo.save(product);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public void updateProduct(int id, Product product) {
        repo.findById(id).ifPresent(p -> p.setName(product.getName()));
    }
}
