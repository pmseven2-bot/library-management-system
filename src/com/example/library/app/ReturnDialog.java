package com.example.library.app;


import javax.swing.*;
import java.awt.*;
import com.example.library.app.LoanController;

public class ReturnDialog extends JDialog {

    public ReturnDialog(JFrame parent, LoanController controller) {
        super(parent, "Return Book", true);

        setLayout(new GridLayout(2, 2, 10, 10));

        JLabel loanLabel = new JLabel("Loan ID:");
        JTextField loanField = new JTextField();

        JButton returnBtn = new JButton("Return");

        returnBtn.addActionListener(e -> {
            try {
                controller.returnBook(loanField.getText());
                JOptionPane.showMessageDialog(this, "Book returned successfully");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(loanLabel);
        add(loanField);
        add(new JLabel());
        add(returnBtn);

        setSize(300, 150);
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}

