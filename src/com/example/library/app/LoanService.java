package com.example.library.app;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class LoanService {

	private final Repository<Book> bookRepo;
	private final Repository<Member> memberRepo;
	private final Repository<Loan> loanRepo;

	public LoanService(Repository<Book> bookRepo, Repository<Member> memberRepo, Repository<Loan> loanRepo) {
		this.bookRepo = bookRepo;
		this.memberRepo = memberRepo;
		this.loanRepo = loanRepo;
	}

	// CHECKOUT
	public Loan checkoutBook(String bookId, String memberId) {
	    Book book = bookRepo.findById(bookId);
	    Member member = memberRepo.findById(memberId);

	    LocalDate checkoutDate = LocalDate.now();
	    LocalDate dueDate = checkoutDate.plusWeeks(2);

	    Loan loan = new Loan(
	            "l" + UUID.randomUUID(),
	            book.getId(),
	            member.getId(),
	            checkoutDate,
	            dueDate
	    );

	    loanRepo.save(loan);
	    return loan;
	}


	// RETURN
	public void returnBook(String loanId) {

		Loan loan = loanRepo.findById(loanId);
		if (loan == null) {
			throw new LoanException("Loan not found: " + loanId);
		}

		loan.setReturnedDate(LocalDate.now());
		loanRepo.save(loan);

		Book book = bookRepo.findById(loan.getBookId());
		if (book != null) {
			book.setLoaned(false);
			bookRepo.save(book);
		}
	}

	// GET OVERDUE LOANS
	public List<Loan> getOverdueLoans() {
		return loanRepo.findAll().stream().filter(Loan::isOverdue).collect(Collectors.toList());
	}

	public Loan getLoan(String id) {
		return loanRepo.findById(id);
	}

	public List<Loan> getAllLoans() {
		return loanRepo.findAll();
	}

}
