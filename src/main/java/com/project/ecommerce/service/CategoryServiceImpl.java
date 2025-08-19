package com.project.ecommerce.service;

import com.project.ecommerce.dtos.CategoryDTO;
import com.project.ecommerce.dtos.CategoryResponseDTO;
import com.project.ecommerce.entity.Category;
import com.project.ecommerce.exception.APIException;
import com.project.ecommerce.exception.ResourceNotFoundException;
import com.project.ecommerce.repositories.CategoryRepository;
import com.project.ecommerce.service.interfaces.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponseDTO getAllCategories(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Category> categoriesPage = categoryRepository.findAll(pageable);
        List<Category> categories = categoryRepository.findAll();
        if(categoriesPage.isEmpty()) {
            throw new APIException("Category list is empty");
        }
        List<CategoryDTO> categoryDTOs = categoriesPage.stream().map(category -> modelMapper.map(category, CategoryDTO.class)).toList();

        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setContent(categoryDTOs);

        return categoryResponseDTO;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category existingCategory = categoryRepository.findByName(categoryDTO.getCategoryName());
        if(existingCategory != null) {
            throw new APIException("Category name " + categoryDTO.getCategoryName() + " already exists");
        }
        Category category = modelMapper.map(categoryDTO, Category.class);

        Category savedCategory = categoryRepository.save(category);

        CategoryDTO savedCategoryDTO = modelMapper.map(savedCategory, CategoryDTO.class);

        return savedCategoryDTO;
    }

    @Override
    public CategoryDTO deleteCategory(int categoryId) {
        Category existingCategory = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        categoryRepository.delete(existingCategory);
        return modelMapper.map(existingCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, int id) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category resource with id: " + id + " not found"));
        existingCategory.setName(categoryDTO.getCategoryName());
        Category updatedCategory = categoryRepository.save(existingCategory);
        return modelMapper.map(updatedCategory, CategoryDTO.class);
    }
}
