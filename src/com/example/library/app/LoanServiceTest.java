package com.example.library.app;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

class LoanServiceTest {

	@Test
	void checkoutBookCreatesLoan() {
		InMemoryRepository<Book> bookRepo = new InMemoryRepository<>();
		InMemoryRepository<Member> memberRepo = new InMemoryRepository<>();
		InMemoryRepository<Loan> loanRepo = new InMemoryRepository<>();
		//LoanService service = 
				new LoanService(bookRepo,memberRepo, loanRepo);
		
		
	}
	@Test
	void getOverdueLoansReturnsOnlyOverdue() {
		InMemoryRepository<Book> bookRepo = new InMemoryRepository<>();
		InMemoryRepository<Member> memberRepo = new InMemoryRepository<>();
		InMemoryRepository<Loan> loanRepo = new InMemoryRepository<>();
		LoanService service = new LoanService(bookRepo,memberRepo, loanRepo);
		

	    Loan overdue = new Loan("L1", "B1", "M1",
	            LocalDate.now().minusDays(10),
	            LocalDate.now().minusDays(5));

	    Loan notOverdue = new Loan("L2", "B2", "M2",
	            LocalDate.now(),
	            LocalDate.now().plusDays(3));

	    loanRepo.save(overdue);
	    loanRepo.save(notOverdue);

	    List<Loan> result = service.getOverdueLoans();

	    assertEquals(1, result.size());
	    assertEquals("L1", result.get(0).getId());
	}

	

}
