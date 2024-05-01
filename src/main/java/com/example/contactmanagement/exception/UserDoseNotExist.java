package com.example.contactmanagement.exception;

public class UserDoseNotExist extends RuntimeException {
    public UserDoseNotExist(String message){
        super(message);
    }
}
