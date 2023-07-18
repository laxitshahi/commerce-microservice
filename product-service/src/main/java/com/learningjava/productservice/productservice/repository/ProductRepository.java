package com.learningjava.productservice.productservice.repository;


import com.learningjava.productservice.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

// Handles communication with DB
// Also provides basic DB functionality
public interface ProductRepository extends MongoRepository<Product, String> {
}
