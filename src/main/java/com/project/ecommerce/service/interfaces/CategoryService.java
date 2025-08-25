package com.project.ecommerce.service.interfaces;

import com.project.ecommerce.dtos.CategoryDTO;
import com.project.ecommerce.dtos.CategoryResponseDTO;
import com.project.ecommerce.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryResponseDTO getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO deleteCategory(int categoryId);
    CategoryDTO updateCategory(CategoryDTO categoryDTO, int id);
}
