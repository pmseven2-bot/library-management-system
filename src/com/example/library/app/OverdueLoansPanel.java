package com.example.library.app;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import com.example.library.app.LoanController;
import com.example.library.app.Loan;

public class OverdueLoansPanel extends JPanel {

    private final LoanController controller;

    public OverdueLoansPanel(LoanController controller) {
        this.controller = controller;
        setLayout(new BorderLayout());

        String[] columns = {"Loan ID", "Book ID", "Member ID", "Checkout", "Due"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        controller.getOverdueLoans().forEach(loan -> {
            model.addRow(new Object[]{
                    loan.getId(),
                    loan.getBookId(),
                    loan.getMemberId(),
                    loan.getCheckoutDate(),
                    loan.getDueDate()
            });
        });

        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
