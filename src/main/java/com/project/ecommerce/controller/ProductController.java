package com.project.ecommerce.controller;

import com.project.ecommerce.dtos.ProductResponseDTO;
import com.project.ecommerce.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<ProductResponseDTO> getAllProducts() {
        List<ProductResponseDTO> productResponseDTOList = productService.getAllProducts();
        return productResponseDTOList;
    }
}
