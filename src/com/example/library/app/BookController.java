package com.example.library.app;

import java.util.List;

public class BookController {

    private final Repository<Book> bookRepo;

    public BookController(Repository<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBook(String id) {
        return bookRepo.findById(id);
    }
}

