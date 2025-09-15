package com.project.ecommerce.service;

import com.project.ecommerce.dtos.ProductResponseDTO;
import com.project.ecommerce.service.interfaces.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return null;
    }
}
