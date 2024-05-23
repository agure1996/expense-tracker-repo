package com.example.agure1996.expense.controller;

import com.example.agure1996.expense.model.Category;
import com.example.agure1996.expense.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    /**
     * Post - Create new Category
     *
     * @param category
     * @return
     */
    @PostMapping("/newCategory")
    public Category newCategory(@RequestBody Category category) {
        return categoryService.newCategory(category);
    }

    /**
     * GET all existing Categories
     *
     * @return
     */
    @GetMapping("/getAllCategories")
    public Iterable<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    /**
     * GET - Category by ID
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    /**
     * Update - Category details
     *
     * @param id
     * @param categoryDetails
     * @return
     */
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        return categoryService.updateCategory(id, categoryDetails);
    }

    /**
     * Delete - Category by id
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable long id) {
        categoryService.deleteCategory(id);

    }

    /**
     * DELETE - All Categories
     */
    @DeleteMapping("/deleteAllCategories")
    public void deleteAllCategories() {
        categoryService.deleteAllCategories();
    }


}
