package com.example.library.app;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;

public class FileLoanRepository {

    private final Path file;
    private final LoanFileParser parser = new LoanFileParser();

    public FileLoanRepository(Path file) {
        this.file = file;
    }

    public void save(Loan loan) {
        try (BufferedWriter writer = Files.newBufferedWriter(
                file,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {

            writer.write(parser.toLine(loan));
            writer.newLine();

        } catch (IOException e) {
            throw new PersistenceException("Failed to save loan", e);
        }
    }

    public List<Loan> findAll() {
        try {
            return Files.lines(file)
                    .map(parser::parseLine)
                    .toList();
        } catch (IOException e) {
            throw new PersistenceException("Failed to read loans", e);
        }
    }

    public Optional<Loan> findById(String id) {
        return findAll().stream()
                .filter(l -> l.getId().equals(id))
                .findFirst();
    }
}
