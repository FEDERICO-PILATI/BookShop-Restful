package com.bookshoprest.controllers;

import com.bookshoprest.models.Book;
import com.bookshoprest.services.BookService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/save")
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @DeleteMapping("/delete/{id}")
    public ObjectNode deleteBook(@PathVariable("id") int id) {
        ObjectNode response = bookService.deleteBook(id);
        return response;
    }

    @PutMapping("/update/{id}")
    public ObjectNode updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        ObjectNode response = bookService.updateBook(id, book);
        return response;
    }

    @GetMapping("/find") // on http://localhost:8085/books/find?title=
    public List<Book> getBookByTitle(@RequestParam("title") String title) {

        //  if user inserts fewer digits than 3, the search doesn't work
        if (title.length() < 3){
            return null;
        }
        return bookService.getByTitle(title);
    }
}
