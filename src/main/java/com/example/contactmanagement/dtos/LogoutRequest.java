package com.example.contactmanagement.dtos;

import lombok.Data;

@Data
public class LogoutRequest {
    public String username;
    public boolean isLogin ;
}
