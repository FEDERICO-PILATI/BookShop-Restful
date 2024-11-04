package com.bookshoprest.controllers;

import com.bookshoprest.models.Author;
import com.bookshoprest.services.AuthorService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/all")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable("id") int id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping("/save")
    public Author saveAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }

    @DeleteMapping("/delete/{id}")
    public ObjectNode deleteAuthor(@PathVariable("id") int id) {
        ObjectNode response = authorService.deleteAuthor(id);
        return response;
    }

    @PutMapping("/update/{id}")
    public ObjectNode updateAuthor(@PathVariable("id") int id, @RequestBody Author author) {
        ObjectNode response = authorService.updateAuthor(id, author);
        return response;
    }
}
