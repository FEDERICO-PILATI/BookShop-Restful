package com.bookshoprest.dao;

import com.bookshoprest.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDao extends CrudRepository<Category, Integer> {
}
