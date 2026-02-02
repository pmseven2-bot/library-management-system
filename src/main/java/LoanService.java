package com.example.library.app;

import java.time.LocalDate;
import java.util.List;

public class LoanService {
	private final Repository<Loan> loanRepo;
	private final Repository<Book> bookRepo;
	private final Repository<Member> memberRepo;

	public LoanService(Repository<Loan> loanRepo, Repository<Book> bookRepo, Repository<Member> memberRepo) {
		this.loanRepo = loanRepo;
		this.bookRepo = bookRepo;
		this.memberRepo = memberRepo;
	}

	// CHECKOUT
	public void checkoutBook(String loanId, String bookId, String memberId) {
		Book book = bookRepo.findById(bookId);
		Member member = memberRepo.findById(memberId);

		LocalDate today = LocalDate.now();
		LocalDate due = today.plusDays(14);

		Loan loan = new Loan(loanId, book.getId(), member.getId(), today, due);
		loanRepo.save(loan);

	}

	// RETURN
	public void returnBook(String loanId) {
		Loan loan = loanRepo.findById(loanId);
		loan.markReturned(LocalDate.now());
	} // GET LOAN

	public Loan getLoan(String id) {
		return loanRepo.findById(id);
	} //
		// LIST LOANS

	public List<Loan> getAllLoans() {
		return loanRepo.findAll();
	}
}
