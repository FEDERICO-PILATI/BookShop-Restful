package com.bookshoprest.services;

import com.bookshoprest.dao.AuthorDao;
import com.bookshoprest.models.Author;
import com.bookshoprest.responsemanager.ResponseManager;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    AuthorDao authorDao;

    @Override
    public List<Author> getAllAuthors() {
        //  I need to cast it to a list of authors
        return (List<Author>) authorDao.findAll();
    }

    @Override
    public Author getAuthorById(int id) {
        Optional<Author> optionalAuthor = authorDao.findById(id);
        if (optionalAuthor.isPresent()) {
            return optionalAuthor.get();
        }
        throw new EntityNotFoundException("Author not found");
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorDao.save(author);
    }

    @Override
    public ObjectNode deleteAuthor(int id) {
        ResponseManager manager;
        Optional<Author> optionalAuthor = authorDao.findById(id);

        if(optionalAuthor.isPresent()) {

           authorDao.delete(optionalAuthor.get());
           manager = new ResponseManager(200, "Author successfully deleted");

        } else {
            manager = new ResponseManager(404, "Author not found");
        }
        return manager.getResponse();
    }

    @Override
    public ObjectNode updateAuthor(int id, Author author) {
        ResponseManager manager;
        Optional<Author> optionalAuthor = authorDao.findById(id);
        if (optionalAuthor.isPresent()) {
            if(optionalAuthor.get().getId() == author.getId()) {
                authorDao.save(author);
                manager = new ResponseManager(200, "Author successfully updated");
            } else {
                manager = new ResponseManager(400, "Author ID in path and body don't match");
            }
        } else {
            manager = new ResponseManager(404, "Author not found");
        }
        return manager.getResponse();
    }
}
