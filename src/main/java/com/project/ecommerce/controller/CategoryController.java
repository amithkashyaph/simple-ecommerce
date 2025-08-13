package com.project.ecommerce.controller;

import com.project.ecommerce.dtos.CategoryDTO;
import com.project.ecommerce.dtos.CategoryResponseDTO;
import com.project.ecommerce.entity.Category;
import com.project.ecommerce.service.interfaces.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/echo")
    public String echoMessage() {
        return "Dummy API to demonstrate Request Param usage";
    }

    @GetMapping("/api/public/categories")
    public ResponseEntity<CategoryResponseDTO> getAllCategories() {
        CategoryResponseDTO categoryResponseDTO = categoryService.getAllCategories();
        return new ResponseEntity<>(categoryResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/api/admin/categories")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO createdCategoryDTO =  categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(createdCategoryDTO, HttpStatus.CREATED);
    }

    @PutMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable int categoryId) {
        try {
            CategoryDTO updatedCategory = categoryService.updateCategory(categoryDTO, categoryId);
            return new ResponseEntity<>(updatedCategory, HttpStatus.NO_CONTENT);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(null, e.getStatusCode());
        }
    }


    @DeleteMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable("categoryId") int id) {
        try{
            CategoryDTO categoryDTO = categoryService.deleteCategory(id);
            return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
        }catch (ResponseStatusException e) {
            return new ResponseEntity<>(null, e.getStatusCode());
        }

    }
}
