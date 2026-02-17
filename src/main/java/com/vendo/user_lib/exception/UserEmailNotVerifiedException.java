package com.vendo.user_lib.exception;

public class UserEmailNotVerifiedException extends RuntimeException {
    public UserEmailNotVerifiedException(String message) {
        super(message);
    }
}
