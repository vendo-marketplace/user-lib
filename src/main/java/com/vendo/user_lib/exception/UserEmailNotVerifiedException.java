package com.vendo.user_lib.exception;

public class UserEmailNotVerifiedException extends UserAuthorizationException {
    public UserEmailNotVerifiedException(String message) {
        super(message);
    }
}
