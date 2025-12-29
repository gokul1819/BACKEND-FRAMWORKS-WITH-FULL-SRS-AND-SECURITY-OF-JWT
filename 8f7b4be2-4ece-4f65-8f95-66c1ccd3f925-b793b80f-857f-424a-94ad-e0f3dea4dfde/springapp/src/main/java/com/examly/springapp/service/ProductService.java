package com.examly.springapp.service;

import com.examly.springapp.model.Product;
import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Integer id);
    Product updateProduct(Integer id, Product product);
    List<Product> getProductsByCategoryName(String categoryName);
    List<Product> getProductsByName(String productName);
}
