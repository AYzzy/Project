package com.example.contactmanagement.dtos;

import lombok.Data;

@Data
public class GetContactRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
}
