package com.rikkeiacademy.demo_product_rest_api.service;

import com.rikkeiacademy.demo_product_rest_api.model.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getListProducts();
    public Product getProductById(Integer proId);
    public Product insertProduct(Product product);
    public Product updateProduct(Product product, Integer proId);
    public Product deleteProduct(Integer proId);
}
