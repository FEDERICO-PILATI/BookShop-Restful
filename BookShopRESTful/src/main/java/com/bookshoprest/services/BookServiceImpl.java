package com.bookshoprest.services;

import com.bookshoprest.dao.BookDao;
import com.bookshoprest.models.Book;
import com.bookshoprest.responsemanager.ResponseManager;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookDao bookDao;

    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) bookDao.findAll();
    }

    @Override
    public Book getBookById(int id) {
        Optional<Book> optionalBook = bookDao.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        }
        throw new EntityNotFoundException("Book not found");
    }

    @Override
    public Book saveBook(Book book) {
        return bookDao.save(book);
    }

    @Override
    public ObjectNode deleteBook(int id) {
        ResponseManager manager;
        Optional<Book> optionalBook = bookDao.findById(id);
        if (optionalBook.isPresent()) {
            bookDao.delete(optionalBook.get());
            manager = new ResponseManager(200, "Book successfully deleted");
        } else {
            manager = new ResponseManager(404, "Book not found");
        }
        return manager.getResponse();
    }

    @Override
    public ObjectNode updateBook(int id, Book book) {
        ResponseManager manager;
        Optional<Book> optionalBook = bookDao.findById(id);
        if (optionalBook.isPresent()){
            if (optionalBook.get().getId() == book.getId()){
                bookDao.save(book);
                manager = new ResponseManager(200, "Book successfully updated");
            } else {
                manager = new ResponseManager(400, "Book ID in path and body don't match");
            }
        } else{
            manager = new ResponseManager(404, "Book not found");
        }
        return manager.getResponse();
    }

    @Override
    public List<Book> getByTitle(String searchedtitle) {
        return bookDao.findByTitle(searchedtitle);
    }
}
