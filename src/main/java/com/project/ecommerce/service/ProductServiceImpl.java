package com.project.ecommerce.service;

import com.project.ecommerce.dtos.ProductDTO;
import com.project.ecommerce.dtos.ProductResponseDTO;
import com.project.ecommerce.entity.Product;
import com.project.ecommerce.repositories.ProductRepository;
import com.project.ecommerce.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return null;
    }

    @Override
    public ProductResponseDTO addProduct(Long categoryId, Product product) {
        return null;
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        return null;
    }
}
