package com.team110.bookreview.exceptions;

import javax.validation.constraints.Email;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
