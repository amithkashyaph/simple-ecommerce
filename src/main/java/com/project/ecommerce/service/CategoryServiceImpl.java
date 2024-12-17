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
        List<Category> categories = categoryRepository.findAll();
        Category category = categories.stream().filter((c) -> c.getId() == categoryId).findFirst().orElse(null);
        if(category == null) {
            return "Category not found";
        }
        categoryRepository.delete(category);
        return "Category with id : " + categoryId + " successfully removed!";
    }

    @Override
    public String updateCategory(Category category, int id) {
        List<Category> categories = categoryRepository.findAll();
        Optional<Category> existingCategory = categories.stream().filter(c -> c.getId() == id).findFirst();
        if(existingCategory.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with id : " + id + " does not exist");
        }
        Category category1 = existingCategory.get();
        category1.setName(category.getName());
        categoryRepository.save(category1);
        return "Category successfully updated";
    }
}
