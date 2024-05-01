package com.example.contactmanagement.dtos.reponse;

import lombok.Data;

@Data
public class DeleteUserResponse {
    private String username;
    private String message= "Successfully Deleted";
}
