package com.learningjava.productservice.productservice.controller;

import com.learningjava.productservice.productservice.dto.ProductRequest;
import com.learningjava.productservice.productservice.dto.ProductResponse;
import com.learningjava.productservice.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    // Injection done by @RequiredArgsConstructor
   private final ProductService productService;
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // @RequestBody does automatic serialization of JSON -> HTTP Requests
    public ProductRequest createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
//       Return product created
        return productRequest;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }



}
