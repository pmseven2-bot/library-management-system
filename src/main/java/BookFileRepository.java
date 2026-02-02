package com.example.library.app;

public class BookFileRepository extends FileRepository<Book> {

    public BookFileRepository(String filename) {
        super(filename);
    }

    @Override
    protected Book fromLine(String line) {
        String[] p = line.split(",");
        Book b = new Book(p[0], p[1], p[2], Genre.valueOf(p[3]));
        b.setLoaned(Boolean.parseBoolean(p[4]));
        return b;
    }

    @Override
    protected String toLine(Book b) {
        return String.join(",",
                b.getId(),
                b.getTitle(),
                b.getAuthor(),
                b.getGenre().name(),
                String.valueOf(b.isLoaned())
        );
    }
}
