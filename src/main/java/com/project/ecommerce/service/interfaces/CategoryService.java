package com.project.ecommerce.service.interfaces;

import com.project.ecommerce.dtos.CategoryDTO;
import com.project.ecommerce.dtos.CategoryResponseDTO;
import com.project.ecommerce.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryResponseDTO getAllCategories();
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    String deleteCategory(int categoryId);
    String updateCategory(Category category, int id);
}
