package com.dziadkouskaya.votingserver.exception;

public class EntityExistedExeption extends ApplicationException {
    public EntityExistedExeption(String message) {
        super(message);
    }

    public EntityExistedExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
