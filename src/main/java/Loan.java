package com.example.library.app;

import java.time.LocalDate;

public class Loan implements Identifiable<String> {

    private final String id;
    private final String bookId;
    private final String memberId;
    private final LocalDate checkoutDate;
    private final LocalDate dueDate;

    private LocalDate returnedDate; // <— ADD THIS

    public Loan(String id, String bookId, String memberId,
                LocalDate checkoutDate, LocalDate dueDate) {
        this.id = id;
        this.bookId = bookId;
        this.memberId = memberId;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.returnedDate = null; // not returned yet
    }

    @Override
    public String getId() {
        return id;
    }

    public String getBookId() {
        return bookId;
    }

    public String getMemberId() {
        return memberId;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    // <— ADD THIS METHOD
    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }

    // <— OPTIONAL BUT VERY USEFUL
    public boolean isOverdue() {
        return returnedDate == null && LocalDate.now().isAfter(dueDate);
    }
}
