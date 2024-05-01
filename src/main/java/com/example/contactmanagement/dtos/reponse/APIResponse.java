package com.example.contactmanagement.dtos.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class APIResponse {
    private  boolean isSuccessful;
    private Object data;
}
