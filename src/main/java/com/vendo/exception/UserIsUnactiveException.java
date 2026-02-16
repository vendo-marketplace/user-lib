package com.vendo.exception;

public class UserIsUnactiveException extends RuntimeException {
    public UserIsUnactiveException(String message) {
        super(message);
    }
}
