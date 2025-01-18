package com.project.ecommerce.service;

import com.project.ecommerce.entity.Category;
import com.project.ecommerce.exception.APIException;
import com.project.ecommerce.exception.ResourceNotFoundException;
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
        List<Category> categories = categoryRepository.findAll();
        if(categories.isEmpty()) {
            throw new APIException("Category list is empty");
        }
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        Category existingCategory = categoryRepository.findByName(category.getName());
        if(existingCategory != null) {
            throw new APIException("Category name " + category.getName() + " already exists");
        }
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(int categoryId) {
        Category existingCategory = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
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
