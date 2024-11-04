package com.bookshoprest.services;

import com.bookshoprest.models.Author;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();

    Author getAuthorById(int id);

    Author saveAuthor(Author author);

    ObjectNode deleteAuthor(int id);

    ObjectNode updateAuthor(int id, Author author);
}
