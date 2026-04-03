package com.vendo.user_lib.exception;

public class UserBlockedException extends UserAuthorizationException {
    public UserBlockedException(String message) {
        super(message);
    }
}
