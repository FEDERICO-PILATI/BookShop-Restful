package com.bookshoprest.services;

import com.bookshoprest.dao.CategoryDao;
import com.bookshoprest.models.Category;
import com.bookshoprest.responsemanager.ResponseManager;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<Category> getAllCategories() {
        return (List<Category>) categoryDao.findAll();
    }

    @Override
    public Category getCategoryById(int id) {
        Optional<Category> optionalCategory = categoryDao.findById(id);
        if (optionalCategory.isPresent()){
            return optionalCategory.get();
        }
        throw new EntityNotFoundException("Category not found");
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public ObjectNode deleteCategory(int id) {

        ResponseManager manager;
        Optional<Category> optionalCategory = categoryDao.findById(id);

        if (optionalCategory.isPresent()){

            categoryDao.delete(optionalCategory.get());
            manager = new ResponseManager(200, "Category successfully deleted");

        } else{

            manager = new ResponseManager(404, "Category not found");

        }
        return manager.getResponse();
    }

    @Override
    public ObjectNode updateCategory(int id, Category category) {

        ResponseManager manager;
        Optional<Category> optionalCategory = categoryDao.findById(id);

        if (optionalCategory.isPresent()){

            if (optionalCategory.get().getId() == category.getId()) {

                categoryDao.save(category);
                manager = new ResponseManager(200, "Category successfully updated");

            } else {
                manager = new ResponseManager(400, "Category ID in path and body do not match");
            }

        } else{
            manager = new ResponseManager(404, "Category not found");
        }
        return manager.getResponse();
    }
}
