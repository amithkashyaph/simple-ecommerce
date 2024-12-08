package com.project.ecommerce.service.interfaces;

import com.project.ecommerce.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
}
