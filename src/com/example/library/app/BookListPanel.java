package com.example.library.app;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

import com.example.library.app.BookController;
import com.example.library.app.Book;

public class BookListPanel extends JPanel {

    private final BookController controller;

    public BookListPanel(BookController controller) {
        this.controller = controller;
        setLayout(new BorderLayout()); // ✅ note: new BorderLayout()

        String[] columns = {"ID", "Title", "Author", "Genre"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Book book : controller.getAllBooks()) {
            model.addRow(new Object[]{
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getGenre()
            });
        }

        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
