package com.example.library.app;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;


import javax.swing.*;
import java.awt.*;

import com.example.library.app.BookController;
import com.example.library.app.MemberController;
import com.example.library.app.LoanController;

public class MainWindow extends JFrame {

    private final BookController bookController;
    private final MemberController memberController;
    private final LoanController loanController;

    private JPanel contentPanel;

    public MainWindow(BookController bookController,
                      MemberController memberController,
                      LoanController loanController) {

        this.bookController = bookController;
        this.memberController = memberController;
        this.loanController = loanController;

        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        initMenuBar();
        initContentPanel();

        setVisible(true);
    }

    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // BOOK MENU
        JMenu bookMenu = new JMenu("Books");
        JMenuItem listBooks = new JMenuItem("List Books");
        listBooks.addActionListener(e -> showBooksPanel());
        bookMenu.add(listBooks);

        // MEMBER MENU
        JMenu memberMenu = new JMenu("Members");
        JMenuItem listMembers = new JMenuItem("List Members");
        listMembers.addActionListener(e -> showMembersPanel());
        memberMenu.add(listMembers);

        // LOAN MENU
        JMenu loanMenu = new JMenu("Loans");

        JMenuItem checkoutBook = new JMenuItem("Checkout Book");
        checkoutBook.addActionListener(e -> showCheckoutDialog());

        JMenuItem returnBook = new JMenuItem("Return Book");
        returnBook.addActionListener(e -> showReturnDialog());

        JMenuItem overdueLoans = new JMenuItem("Overdue Loans");
        overdueLoans.addActionListener(e -> showOverduePanel());

        loanMenu.add(checkoutBook);
        loanMenu.add(returnBook);
        loanMenu.add(overdueLoans);

        menuBar.add(bookMenu);
        menuBar.add(memberMenu);
        menuBar.add(loanMenu);

        setJMenuBar(menuBar);
    }

    private Object showReturnDialog() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object showCheckoutDialog() {
		// TODO Auto-generated method stub
		return null;
	}

	private void initContentPanel() {
        contentPanel = new JPanel(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);
    }

    private void setContent(Component component) {
        contentPanel.removeAll();
        contentPanel.add(component, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    // PANELS (you will implement these next)
    private void showBooksPanel() {
        setContent(new BookListPanel(bookController));
    }

    private void showMembersPanel() {
        setContent(new MemberListPanel(memberController));
    }

    private void showOverduePanel() {
        setContent(new OverdueLoansPanel(loanController));
    }

    // DIALOGS (you will implement these next)
   // private void showCheckoutDialog() {
    //    new CheckoutDialog(this, loanController);
    //}

   // private void showReturnDialog() {
    //    new ReturnDialog(this, loanController);
    //}
}
