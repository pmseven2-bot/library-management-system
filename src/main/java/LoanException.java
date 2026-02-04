package com.example.library.app;

public class LoanException extends LibraryException {

    public LoanException() {
        super();
    }

    public LoanException(String message) {
        super(message);
    }

    public LoanException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoanException(Throwable cause) {
        super(cause);
    }
}

