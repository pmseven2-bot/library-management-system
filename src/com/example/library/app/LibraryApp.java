package com.example.library.app;

import java.time.LocalDate;

public class LibraryApp {
    public static void main(String[] args) {

        Repository<Book> bookRepo = new InMemoryRepository<>();
        Repository<Member> memberRepo = new InMemoryRepository<>();
        Repository<Loan> loanRepo = new InMemoryRepository<>();

        LibraryService libraryService = new LibraryService(bookRepo, memberRepo);
        LoanService loanService = new LoanService(bookRepo, memberRepo, loanRepo);

        // Add book
        Book dune = new Book("b1", "Dune", "Frank Herbert", Genre.SCIENCE);
        libraryService.addBook(dune);

        // Add member
        Member patrick = new Member("m1", "Patrick", LocalDate.now(), MembershipLevel.STANDARD);
        libraryService.addMember(patrick);

        // Checkout book (correct order)
        Loan loan = loanService.checkoutBook("b1", "m1");

        // Print loan details
        System.out.println("Loan created:");
        System.out.println("Loan ID: " + loan.getId());
        System.out.println("Book ID: " + loan.getBookId());
        System.out.println("Member ID: " + loan.getMemberId());
        System.out.println("Checkout: " + loan.getCheckoutDate());
        System.out.println("Due: " + loan.getDueDate());

        // Return the book
        loanService.returnBook(loan.getId());

        System.out.println("Returned on: " + loan.getReturnedDate());

        // List all books
        System.out.println("\nAll Books:");
        libraryService.getAllBooks().forEach(b -> System.out.println(b.getTitle()));

        // List all members
        System.out.println("\nAll Members:");
        libraryService.getAllMembers().forEach(m -> System.out.println(m.getName()));

        // List all loans
        System.out.println("\nAll Loans:");
        loanService.getAllLoans().forEach(l -> System.out.println(l.getId()));
    }
}
