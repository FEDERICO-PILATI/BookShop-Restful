package com.bookshoprest.dao;

import com.bookshoprest.models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookDao extends CrudRepository<Book, Integer> {

    //  custom query using author lastname
    @Query(value = "SELECT * FROM book WHERE title LIKE %:searchedtitle%", nativeQuery = true)
    List<Book> findByTitle(@Param("searchedtitle") String searchedtitle);
}
