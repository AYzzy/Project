package com.example.contactmanagement.dtos.reponse;

import lombok.Data;

@Data
public class ContactDtoResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String message ="Successfully Created A New Contact ";
}
