package com.example.library.app;



public class AppInitializer {

    public static void main(String[] args) {

        // -----------------------------
        // REPOSITORIES
        // -----------------------------
        Repository<Book> bookRepo = new InMemoryRepository<>();
        Repository<Member> memberRepo = new InMemoryRepository<>();
        Repository<Loan> loanRepo = new InMemoryRepository<>();

        // -----------------------------
        // SERVICES
        // -----------------------------
        LibraryService libraryService = new LibraryService(bookRepo, memberRepo);
        LoanService loanService = new LoanService(bookRepo, memberRepo, loanRepo);

        // -----------------------------
        // CONTROLLERS
        // -----------------------------
        BookController bookController = new BookController(bookRepo);
        MemberController memberController = new MemberController(memberRepo);
        LoanController loanController = new LoanController(loanService);

        // -----------------------------
        // LAUNCH SWING UI
        // -----------------------------
        javax.swing.SwingUtilities.invokeLater(() -> {
            new MainWindow(bookController, memberController, loanController);
        });
    }
}

