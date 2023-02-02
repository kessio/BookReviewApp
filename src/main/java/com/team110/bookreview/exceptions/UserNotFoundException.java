package com.team110.bookreview.exceptions;

import javax.validation.constraints.Email;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
