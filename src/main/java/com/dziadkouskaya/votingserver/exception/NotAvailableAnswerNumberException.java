package com.dziadkouskaya.votingserver.exception;

public class NotAvailableAnswerNumberException extends ApplicationException {
    public NotAvailableAnswerNumberException(String message) {
        super(message);
    }

    public NotAvailableAnswerNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
