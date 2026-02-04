package com.example.library.app;

import java.io.*;
import java.nio.file.*;
import java.util.*;

//abstract → you cannot create a FileRepository directly; subclasses must implement conversion 
//methods.
//<T extends Identifiable<String>> → the repository only stores objects that have a 
//String ID.
//implements Repository<T> → this class provides a file‑based implementation of your generic repository
//interface.
public abstract class FileRepository<T extends Identifiable<String>>
        implements Repository<T> {
//Stores the path to the file where items will be saved.
    private final Path filePath;
//protected → only subclasses can create instances.
    protected FileRepository(String filename) {
  //Paths.get(filename) → converts a string like "books.txt" into a Path object.
    	
        this.filePath = Paths.get(filename);
        // makes sure the file is created before reading/writing.
        ensureFileExists();
    }

    private void ensureFileExists() {
        try {
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            throw new PersistenceException("Cannot create file: " + filePath, e);
        }
    }

    //These must be implemented by subclasses 
    //(e.g., BookFileRepository):
    //fromLine → convert a line of text into a T object.
    //toLine → convert a T object into a line of text.
    protected abstract T fromLine(String line);
    protected abstract String toLine(T item);

    @Override
    public void save(T item) {
        List<T> all = findAll();//Load all items from the file.
        all.removeIf(i -> i.getId().equals(item.getId()));//Remove any existing item with the same ID.
        all.add(item);//Add the new/updated item.
        writeAll(all);//Rewrite the entire file.
    }

    @Override
    public T findById(String id) {
        return findAll().stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<T> findAll() {
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            List<T> items = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                items.add(fromLine(line));
            }
            return items;
        } catch (IOException e) {
            throw new PersistenceException("Error reading file: " + filePath, e);
        }
    }

    @Override
    public void deleteById(String id) {
        List<T> all = findAll();
        all.removeIf(i -> i.getId().equals(id));
        writeAll(all);
    }

    private void writeAll(List<T> items) {
        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            for (T item : items) {
                writer.write(toLine(item));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new PersistenceException("Error writing file: " + filePath, e);
        }
    }
}
