package com.bookshoprest.models;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "author_id", referencedColumnName = "id")

    private Author author;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "category_id", referencedColumnName = "id")

    private Category category;

    @Column(name = "price")
    private double price;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
