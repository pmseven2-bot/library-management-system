package com.example.library.app;

public class Book extends LibraryItem {

    private final String author;
    private final Genre genre;

    // NEW FIELD — tracks whether the book is currently loaned
    private boolean loaned;

    public Book(String id, String title, String author, Genre genre) {
        super(id, title);
        this.author = author;
        this.genre = genre;
        this.loaned = false; // default: available
    }

    public String getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    // NEW METHODS — used by LoanService
    public boolean isLoaned() {
        return loaned;
    }

    public void setLoaned(boolean loaned) {
        this.loaned = loaned;
    }

    @Override
    public String getItemType() {
        return "BOOK";
    }
}
