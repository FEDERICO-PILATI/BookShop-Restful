package com.bookshoprest.dao;

import com.bookshoprest.models.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AuthorDao extends CrudRepository<Author, Integer> {
}
