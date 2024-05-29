package com.rikkeiacademy.demo_product_rest_api.service.impl;

import com.rikkeiacademy.demo_product_rest_api.model.entity.Product;
import com.rikkeiacademy.demo_product_rest_api.repository.ProductRepository;
import com.rikkeiacademy.demo_product_rest_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getListProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer proId) {
        return productRepository.findById(proId).orElseThrow(()-> new NoSuchElementException("Khong ton tai san pham co ma: "+proId));
    }

    @Override
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product, Integer proId) {
        Product p = productRepository.findById(proId).orElseThrow(() -> new NoSuchElementException("Khong ton tai san pham co ma: " + proId));
        if(p!=null){
            p = Product.builder()
                    .price(product.getPrice())
                    .producer(product.getProducer())
                    .yearMaking(product.getYearMaking())
                    .proName(product.getProName())
                    .proId(product.getProId())
                    .build();
            productRepository.save(p);
            return p;
        }
        return null;
    }

    @Override
    public Product deleteProduct(Integer proId) {
        Product p = productRepository.findById(proId).orElseThrow(() -> new NoSuchElementException("Khong ton tai san pham co ma: " + proId));
        if(p!=null){
            productRepository.delete(p);
            return p;
        }
        return null;
    }
}
