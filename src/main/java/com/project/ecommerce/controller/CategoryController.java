package com.project.ecommerce.controller;

import com.project.ecommerce.entity.Category;
import com.project.ecommerce.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/api/admin/categories")
    public String createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return "Creating Category";
    }

    @PutMapping("/api/admin/categories/{categoryId}")
    public String updateCategory(@RequestBody Category category, @PathVariable int categoryId) {
        return categoryService.updateCategory(category, categoryId);
    }


    @DeleteMapping("/api/admin/categories/{categoryId}")
    public String deleteCategory(@PathVariable("categoryId") int id) {
        String status = categoryService.deleteCategory(id);
        return status;
    }
}
