package com.vendo.user_lib.exception;

public class UserAlreadyCompletedException extends RuntimeException {
  public UserAlreadyCompletedException(String message) {
    super(message);
  }
}
