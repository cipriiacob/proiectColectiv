package com.example.exceptions;

/**
 * Created by Cipri on 09-Nov-16.
 */
public class UserException extends RuntimeException {

    public UserException() {

        super();
    }

    public UserException(String message) {

        super(message);
    }

    public UserException(Throwable cause) {

        super(cause);
    }

    public UserException(String message, Throwable throwable) {

        super(message, throwable);
    }

}
