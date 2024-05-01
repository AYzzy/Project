package com.example.contactmanagement.exception;

public class UserAlreadyExistException extends ContactManagerException {
    public UserAlreadyExistException(String message){
        super(message);
    }
}
