package com.example.exceptions;

/**
 * Created by Cipri on 09-Nov-16.
 */
public class DuplicatedUserException extends RuntimeException {

    public DuplicatedUserException() {

    }

    public DuplicatedUserException(String message) {

        super(message);
    }

    public DuplicatedUserException(String message, Throwable cause) {

        super(message, cause);
    }

    public DuplicatedUserException(Throwable cause) {

        super(cause);
    }
}
