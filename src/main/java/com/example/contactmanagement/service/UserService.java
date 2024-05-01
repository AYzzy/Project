package com.example.contactmanagement.service;


import com.example.contactmanagement.data.model.Contact;
import com.example.contactmanagement.data.model.User;
import com.example.contactmanagement.dtos.ContactDto;
import com.example.contactmanagement.dtos.LoginRequest;
import com.example.contactmanagement.dtos.LogoutRequest;
import com.example.contactmanagement.dtos.UserRequest;
import com.example.contactmanagement.dtos.request.*;

import java.util.List;

public interface UserService {

    String register(UserRequest userRequest);

    String login(LoginRequest loginRequest);
    String logout(LogoutRequest logoutRequest);
    void update(UpdateUserRequest updateContactRequest);
    User delete(DeleteUserRequest deleteUserRequest);

    Contact Contact(ContactDto contactDto);

    Contact updateContact(UpdateContactRequest updateContactRequest);

    String deleteContact(DeleteContactRequest username);

    Contact findContactByPhoneNumber(FindContactRequest findContactRequest);

    List<Contact> findAllContact();
}
