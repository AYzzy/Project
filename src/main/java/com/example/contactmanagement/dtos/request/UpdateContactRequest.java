package com.example.contactmanagement.dtos.request;

import lombok.Data;

@Data
public class UpdateContactRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String NewFirstName;
    private String newLastName;
    private String newPhoneNumber;
    private String newEmail;
}
