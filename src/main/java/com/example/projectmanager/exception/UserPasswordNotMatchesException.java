package com.example.projectmanager.exception;

public class UserPasswordNotMatchesException extends RuntimeException{
    public UserPasswordNotMatchesException() {
    }

    public UserPasswordNotMatchesException(String message) {
        super(message);
    }
}
