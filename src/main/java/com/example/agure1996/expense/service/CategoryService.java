package com.example.agure1996.expense.service;


import com.example.agure1996.expense.model.Category;
import com.example.agure1996.expense.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Create a new Category
     */
    public Category newCategory(Category category) {
        return categoryRepository.save(category);
    }

    /**
     * Get all Categories
     */
    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    /**
     * Get Category by Id
     */
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    /**
     * Update Category
     */

    public Category updateCategory(Long id, Category categoryDetails) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            Category existingCategory = category.get();
            existingCategory.setName(categoryDetails.getName());
            existingCategory.setUser(categoryDetails.getUser());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }

    /**
     * Delete All Categories
     */

    public void deleteAllCategories() {

        categoryRepository.deleteAll();
    }

    /**
     * Delete Category
     */
    public void deleteCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) categoryRepository.deleteById(id);
    }


}
