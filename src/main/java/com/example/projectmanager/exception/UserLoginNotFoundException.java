package com.example.projectmanager.exception;

public class UserLoginNotFoundException extends RuntimeException{

    public UserLoginNotFoundException() {
    }

    public UserLoginNotFoundException(String message) {
        super(message);
    }
}
