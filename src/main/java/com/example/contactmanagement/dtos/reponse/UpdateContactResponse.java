package com.example.contactmanagement.dtos.reponse;

import lombok.Data;

@Data
public class UpdateContactResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String newFirstName;
    private String newLastName;
    private String newEmail;
    private String newPhoneNumber;
    private String message="Done";
}
