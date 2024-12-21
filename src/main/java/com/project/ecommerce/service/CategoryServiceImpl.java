package com.project.ecommerce.service;

import com.project.ecommerce.entity.Category;
import com.project.ecommerce.repositories.CategoryRepository;
import com.project.ecommerce.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(int categoryId) {
        Category existingCategory = categoryRepository.findById(categoryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category resource with id: " + categoryId + " not found"));
        categoryRepository.delete(existingCategory);
        return "Category with id : " + categoryId + " successfully removed!";
    }

    @Override
    public String updateCategory(Category category, int id) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category resource with id: " + id + " not found"));
        category.setId(existingCategory.getId());
        categoryRepository.save(category);
        return "Category successfully updated";
    }
}
