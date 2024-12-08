package com.project.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @GetMapping("/api/public/categories")
    public String getAllCategories() {
        return "Get All Categories";
    }

    @PostMapping("/api/admin/category")
    public String createCategory() {
        return "Creating Category";
    }
}
