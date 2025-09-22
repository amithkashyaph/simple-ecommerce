package com.project.ecommerce.controller;

import com.project.ecommerce.dtos.ProductDTO;
import com.project.ecommerce.dtos.ProductResponseDTO;
import com.project.ecommerce.entity.Product;
import com.project.ecommerce.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public List<ProductResponseDTO> getAllProducts() {
        List<ProductResponseDTO> productResponseDTOList = productService.getAllProducts();
        return productResponseDTOList;
    }

    @PostMapping("/categories/{categoryId}/product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody Product product, @PathVariable("categoryId") Long categoryId) {
        return null;
    }

}
