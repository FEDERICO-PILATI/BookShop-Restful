package com.bookshoprest.services;

import com.bookshoprest.models.Category;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(int id);

    Category saveCategory(Category category);

    ObjectNode deleteCategory(int id);

    ObjectNode updateCategory(int id, Category category);
}
