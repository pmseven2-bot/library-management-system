package com.example.library.app;

//The parser is the “translator” layer
public class BookFileParser {

	// Expected format: id,title,author, genre
	public Book parseLine(String line) {
		String[] parts = line.split(",");
		if (parts.length < 4) {
			throw new IllegalArgumentException("Invalid book line: " + line);

		}

		String id = parts[0];
		String title = parts[1];
		String author = parts[2];
		Genre genre = Genre.valueOf(parts[3]); // convert String → enum return new Book(id, title, author, genre);

		return new Book(id, title, author, genre);
	}

	public String toLine(Book book) {
		return String.join(",", book.getId(), book.getTitle(), book.getAuthor(), book.getGenre().name());
	}

}
