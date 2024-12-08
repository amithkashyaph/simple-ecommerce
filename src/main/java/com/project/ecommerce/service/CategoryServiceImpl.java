package com.project.ecommerce.service;

import com.project.ecommerce.entity.Category;
import com.project.ecommerce.service.interfaces.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    List<Category> categories = new ArrayList<>();
    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setId(categories.size() + 1);
        categories.add(category);
    }

    @Override
    public String deleteCategory(int categoryId) {
        Category category = categories.stream().filter((c) -> c.getId() == categoryId).findFirst().orElse(null);
        if(category == null) {
            return "Category not found";
        }
        categories.remove(category);
        return "Category with id : " + categoryId + " successfully removed!";
    }
}
