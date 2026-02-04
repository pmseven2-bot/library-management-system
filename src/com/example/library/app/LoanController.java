package com.example.library.app;

import java.util.List;

public class LoanController {
	private final LoanService loanService;

	public LoanController(LoanService loanService) {
		this.loanService = loanService;
	}

	public void checkoutBook(String bookId, String memberId) {
		loanService.checkoutBook(bookId, memberId);
	}

	public void returnBook(String loanId) {
		loanService.returnBook(loanId);
	}

	public List<Loan> getOverdueLoans() {
		return loanService.getOverdueLoans();
	}

	public List<Loan> getAllLoans() {
		return loanService.getAllLoans();
	}

}
