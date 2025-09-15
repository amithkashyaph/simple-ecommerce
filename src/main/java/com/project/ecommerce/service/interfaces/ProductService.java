package com.project.ecommerce.service.interfaces;

import com.project.ecommerce.dtos.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    List<ProductResponseDTO> getAllProducts();
}
