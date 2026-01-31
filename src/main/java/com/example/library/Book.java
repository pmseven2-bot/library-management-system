package com.example.library.app;


public class Book extends LibraryItem {

    private final String author;
    private final Genre genre;

    public Book(String id, String title, String author, Genre genre) {
        super(id, title);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String getItemType() {
        return "BOOK";
    }
}

