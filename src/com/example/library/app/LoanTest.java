package com.example.library.app;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class LoanTest {

	@Test
	void loanIsOverdueWhenPastDueDate() {
		Loan loan = new Loan("L1", "B1", "M1", LocalDate.now().minusDays(10), LocalDate.now().minusDays(5));
		assertTrue(loan.isOverdue());
	}
}
