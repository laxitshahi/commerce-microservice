package com.learningjava.productservice.productservice.service;

import com.learningjava.productservice.productservice.dto.ProductRequest;
import com.learningjava.productservice.productservice.dto.ProductResponse;
import com.learningjava.productservice.productservice.model.Product;
import com.learningjava.productservice.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j // LOGS
public class ProductService{

    private final ProductRepository productRepository;

    // THIS IS AUTO CREATED BY LOMBOK @RequiredArgsConstructor
//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    public void createProduct(ProductRequest productRequest){
        // We do not need id because mongo will call it auto increment
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        // {} is a place holder that can be used because of slf4j
        log.info("Product {} has been saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        // this::mapToProductResponse is a replacement for product -> mapToProductResponse()
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}