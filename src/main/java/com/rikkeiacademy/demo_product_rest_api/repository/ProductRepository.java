package com.rikkeiacademy.demo_product_rest_api.repository;

import com.rikkeiacademy.demo_product_rest_api.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
