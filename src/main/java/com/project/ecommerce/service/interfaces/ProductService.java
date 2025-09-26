package com.project.ecommerce.service.interfaces;

import com.project.ecommerce.dtos.ProductResponseDTO;
import com.project.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO addProduct(Product product);

    ProductResponseDTO getProductById(Long id);
}
