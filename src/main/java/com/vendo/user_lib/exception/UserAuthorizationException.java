package com.vendo.user_lib.exception;

public class UserAuthorizationException extends RuntimeException {
    public UserAuthorizationException(String message) {
        super(message);
    }
}
