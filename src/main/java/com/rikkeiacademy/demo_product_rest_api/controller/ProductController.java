package com.rikkeiacademy.demo_product_rest_api.controller;

import com.rikkeiacademy.demo_product_rest_api.model.entity.Product;
import com.rikkeiacademy.demo_product_rest_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getListProducts(){
        return new ResponseEntity<>(productService.getListProducts(), HttpStatus.OK);
    }

    @GetMapping("/{proId}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer proId){
        return new ResponseEntity<>(productService.getProductById(proId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.insertProduct(product),HttpStatus.OK);
    }

    @PutMapping("/{proId}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Integer proId){
        return new ResponseEntity<>(productService.updateProduct(product, proId),HttpStatus.OK);
    }

    @DeleteMapping("/{proId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Integer proId){
        return new ResponseEntity<>(productService.deleteProduct(proId),HttpStatus.OK);
    }
}
