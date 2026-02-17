package com.vendo.user_lib.exception;

public class UserIsUnactiveException extends RuntimeException {
    public UserIsUnactiveException(String message) {
        super(message);
    }
}
