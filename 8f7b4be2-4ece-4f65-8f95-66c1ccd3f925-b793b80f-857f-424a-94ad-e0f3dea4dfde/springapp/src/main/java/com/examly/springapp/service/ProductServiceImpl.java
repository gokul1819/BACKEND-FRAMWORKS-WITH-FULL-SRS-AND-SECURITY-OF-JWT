package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Product;
import com.examly.springapp.repository.ProductRepo;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepo productRepo;
    
    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }
    
    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
    
    @Override
    public Product getProductById(Integer id) {
        return productRepo.findById(id).orElse(null);
    }
    
    @Override
    public Product updateProduct(Integer id, Product product) {
        product.setProductId(id);
        return productRepo.save(product);
    }
    
    @Override
    public List<Product> getProductsByCategoryName(String categoryName) {
        return productRepo.findByCategoryName(categoryName);
    }
    
    @Override
    public List<Product> getProductsByName(String productName) {
        return productRepo.findByProductName(productName);
    }
}
