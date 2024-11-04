package com.bookshoprest.services;

import com.bookshoprest.models.Book;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(int id);

    Book saveBook(Book book);

    ObjectNode deleteBook(int id);

    ObjectNode updateBook(int id, Book book);

    List<Book> getByTitle(String searchedtitle);
}
