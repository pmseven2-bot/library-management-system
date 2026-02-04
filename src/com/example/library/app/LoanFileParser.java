package com.example.library.app;

import java.time.LocalDate;

public class LoanFileParser {

    // Expected format: id,bookId,borrowerName,loanDate
    public Loan parseLine(String line) {
        String[] parts = line.split(",");
        if (parts.length < 4) {
            throw new IllegalArgumentException("Invalid loan line: " + line);
        }
         String id = parts[0];
         String bookId = parts[0];
         String memberId = parts[0];
         LocalDate checkoutDate = LocalDate.parse(parts[3]);
         LocalDate dueDate = LocalDate.parse(parts[4]);
         
         return new Loan(id, bookId, memberId, checkoutDate, dueDate);
    }

    public String toLine(Loan loan) {
        return String.join(",",
         
                loan.getId(),
                loan.getBookId(),
                loan.getMemberId(),
                loan.getCheckoutDate().toString(),//String.join requires all arguments to be Strings
                loan.getDueDate().toString()
                
        );
    }
}

