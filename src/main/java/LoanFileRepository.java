package com.example.library.app;

import java.time.LocalDate;

public class LoanFileRepository extends FileRepository<Loan> {

    public LoanFileRepository(String filename) {
        super(filename);
    }

    @Override
    protected Loan fromLine(String line) {
        String[] p = line.split(",");
        Loan loan = new Loan(
                p[0], p[1], p[2],
                LocalDate.parse(p[3]),
                LocalDate.parse(p[4])
        );
        if (!p[5].equals("null")) {
            loan.setReturnedDate(LocalDate.parse(p[5]));
        }
        return loan;
    }

    @Override
    protected String toLine(Loan loan) {
        return String.join(",",
                loan.getId(),
                loan.getBookId(),
                loan.getMemberId(),
                loan.getCheckoutDate().toString(),
                loan.getDueDate().toString(),
                loan.getReturnedDate() == null ? "null" : loan.getReturnedDate().toString()
        );
    }
}

