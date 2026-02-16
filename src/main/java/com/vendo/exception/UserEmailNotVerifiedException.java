package com.vendo.exception;

public class UserEmailNotVerifiedException extends RuntimeException {
    public UserEmailNotVerifiedException(String message) {
        super(message);
    }
}
