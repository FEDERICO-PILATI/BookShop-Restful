package com.bookshoprest.controllers;

import com.bookshoprest.models.Category;
import com.bookshoprest.services.CategoryService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable("id") int id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/save")
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public ObjectNode deleteCategory(@PathVariable("id") int id) {
        ObjectNode response = categoryService.deleteCategory(id);
        return response;
    }

    @PutMapping("/update/{id}")
    public ObjectNode updateCategory(@PathVariable("id") int id, @RequestBody Category category) {
        ObjectNode response = categoryService.updateCategory(id, category);
        return response;
    }
}
