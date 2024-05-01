package com.example.contactmanagement.controller;


import com.example.contactmanagement.data.model.Contact;
import com.example.contactmanagement.data.model.User;
import com.example.contactmanagement.dtos.ContactDto;
import com.example.contactmanagement.dtos.LoginRequest;
import com.example.contactmanagement.dtos.LogoutRequest;
import com.example.contactmanagement.dtos.UserRequest;
import com.example.contactmanagement.dtos.reponse.APIResponse;
import com.example.contactmanagement.dtos.request.DeleteContactRequest;
import com.example.contactmanagement.dtos.request.DeleteUserRequest;
import com.example.contactmanagement.dtos.request.FindContactRequest;
import com.example.contactmanagement.dtos.request.UpdateContactRequest;
import com.example.contactmanagement.exception.ContactManagerException;
import com.example.contactmanagement.exception.UserDoseNotExist;
import com.example.contactmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/contact")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequest userRequest){
        try{
            String response = userService.register(userRequest);
            return new ResponseEntity<>(new APIResponse(true, response),CREATED);
        }catch (ContactManagerException e){
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            String response = userService.login(loginRequest);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ContactManagerException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody LogoutRequest logoutRequest) {
        try {
            String response = userService.logout(logoutRequest);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ContactManagerException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody DeleteUserRequest deleteUserRequest){
        try {
            var response = userService.delete(deleteUserRequest);
            return new ResponseEntity<>(new APIResponse(true,response), CREATED);
        }catch (UserDoseNotExist e){
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }

    @PostMapping("/Contact")
    public ResponseEntity<?> Contact(@RequestBody ContactDto contactDto) {
        try {
            Contact response = userService.Contact(contactDto);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ContactManagerException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("/updateContact")
    public ResponseEntity<?> updateContact(@RequestBody UpdateContactRequest updateContactRequest) {
        try {
            Contact response = userService.updateContact(updateContactRequest);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ContactManagerException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @DeleteMapping("/deleteContact")
    public ResponseEntity<?> deleteContact(@RequestBody DeleteContactRequest deleteContactRequest) {
        try {
            var response = userService.deleteContact(deleteContactRequest);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ContactManagerException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("/findByPhoneNumber")
    public ResponseEntity<?> findContactByPhoneNumber(@RequestBody FindContactRequest findContactRequest) {
        try {
            var response = userService.findContactByPhoneNumber(findContactRequest);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ContactManagerException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("/findAllContact")
    public ResponseEntity<?> findAllContact() {
        try {
            var response = userService.findAllContact();
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ContactManagerException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }


}
