package com.vendo.user_lib.exception;

public class UserIsUnactiveException extends UserAuthorizationException {
    public UserIsUnactiveException(String message) {
        super(message);
    }
}
