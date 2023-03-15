package com.example.projectmanager.exception;

public class UserLoginAlreadyRegisteredException extends RuntimeException{

    public UserLoginAlreadyRegisteredException() {
    }

    public UserLoginAlreadyRegisteredException(String message) {
        super(message);
    }
}
