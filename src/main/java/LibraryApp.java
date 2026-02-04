package com.example.library.app;

import java.time.LocalDate;

public class LibraryApp {
	public static void main(String[] args) {
		// REPOSITORIES
		Repository<Book> bookRepo = new InMemoryRepository<>();
		Repository<Member> memberRepo = new InMemoryRepository<>();
		Repository<Loan> loanRepo = new InMemoryRepository<>();

		// SERVICES
		LibraryService libraryService = new LibraryService(bookRepo, memberRepo);
		LoanService loanService = new LoanService(loanRepo, bookRepo, memberRepo);

		// ADD A BOOK
		Book dune = new Book("b1", "Dune", "Frank Herbert", Genre.SCIENCE);
		libraryService.addBook(dune);

		// ADD A MEMBER
		Member patrick = new Member("m1", "Patrick", LocalDate.now(), MembershipLevel.STANDARD);
		libraryService.addMember(patrick);

		// CHECKOUT A BOOK
		loanService.checkoutBook("l1", "b1");

		// PRINT LOAN DETAILS
		Loan loan = loanService.getLoan("l1");
		System.out.println("Loan created:");
		System.out.println("Book ID: " + loan.getBookId());
		System.out.println("Member ID: " + loan.getMemberId());
		System.out.println("Checkout: " + loan.getCheckoutDate());
		System.out.println("Due: " + loan.getDueDate());

		// RETURN THE BOOK
		loanService.returnBook("l1");

		// PRINT RETURN DATE
		System.out.println("Returned on: " + loan.getReturnedDate());

		// LIST ALL BOOKS
		System.out.println("\nAll Books:");
		libraryService.getAllBooks().forEach(b -> System.out.println(b.getTitle())); 
		
		// LIST ALL MEMBERS
		System.out.println("\nAll Members:"); libraryService.getAllMembers().forEach(m -> System.out.println(m.getName()));
		
		// LIST ALL LOANS
		System.out.println("\nAll Loans:"); loanService.getAllLoans().forEach(l -> System.out.println(l.getId()));
	}
}
