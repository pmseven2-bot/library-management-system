package com.example.library.app;



import javax.swing.*;
import java.awt.*;
import com.example.library.app.LoanController;

public class CheckoutDialog extends JDialog {

    public CheckoutDialog(JFrame parent, LoanController controller) {
        super(parent, "Checkout Book", true);

        setLayout(new GridLayout(3, 2, 10, 10));

        JLabel bookLabel = new JLabel("Book ID:");
        JTextField bookField = new JTextField();

        JLabel memberLabel = new JLabel("Member ID:");
        JTextField memberField = new JTextField();

        JButton checkoutBtn = new JButton("Checkout");

        checkoutBtn.addActionListener(e -> {
            try {
                controller.checkoutBook(bookField.getText(), memberField.getText());
                JOptionPane.showMessageDialog(this, "Book checked out successfully");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(bookLabel);
        add(bookField);
        add(memberLabel);
        add(memberField);
        add(new JLabel());
        add(checkoutBtn);

        setSize(300, 180);
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}
