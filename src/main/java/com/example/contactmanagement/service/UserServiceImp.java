package com.example.contactmanagement.service;

import com.example.contactmanagement.data.model.Contact;
import com.example.contactmanagement.data.model.User;
import com.example.contactmanagement.data.repository.UserRepository;
import com.example.contactmanagement.dtos.ContactDto;
import com.example.contactmanagement.dtos.LoginRequest;
import com.example.contactmanagement.dtos.LogoutRequest;
import com.example.contactmanagement.dtos.UserRequest;
import com.example.contactmanagement.dtos.reponse.DeleteUserResponse;
import com.example.contactmanagement.dtos.request.*;
import com.example.contactmanagement.exception.UserDoseNotExist;
import com.example.contactmanagement.exception.UserNotFoundException;
import com.example.contactmanagement.exception.UsernameDoseNotExist;
import com.example.contactmanagement.exception.WrongUserName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContactService contactService;

    @Override
    public String register(UserRequest userRequest) {

        existByUsername(userRequest.getUsername().toLowerCase());
        User user1= new User();
        user1.setUsername(userRequest.getUsername());
        user1.setFirstName(userRequest.getFirstName());
        user1.setLastName(userRequest.getLastName());
        user1.setPassword(userRequest.getPassword());
        userRepository.save(user1);
        return "successful";
    }

    private User existByUsername(String username) {
        if(userRepository.existsByUsername(username))
            throw new UsernameDoseNotExist("UserName Exist Already");
        return null;
    }

    @Override
    public String login(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if (user == null ) {
            throw new UserNotFoundException("User not found");
        }
        if(!user.getPassword().equals(loginRequest.getPassword())){ throw new WrongUserName("wrong password");}
        user.setIsLogin(true);
        userRepository.save(user);
        return "YOU HAVE SUCCESSFULLY LOGGED IN";
    }


    @Override
    public String logout(LogoutRequest logoutRequest) {
        User user = userRepository.findByUsername(logoutRequest.getUsername());
        user.setUsername(logoutRequest.getUsername());
        user.setIsLogin(false);
        userRepository.save(user);
        return "LOGOUT SUCCESSFUL";
    }

    @Override
    public void update(UpdateUserRequest updateContactRequest) {
        User user = userRepository.findByUsername(updateContactRequest.getUsername());

        user.setUsername(updateContactRequest.getNewUsername());
        user.setPassword(updateContactRequest.getNewPassword());
        userRepository.save(user);
    }

    @Override
    public User delete(DeleteUserRequest deleteUserRequest) {
        User user = findByUsername(deleteUserRequest.getUsername());
        userRepository.delete(user);
        DeleteUserResponse deleteUserResponse = new DeleteUserResponse();
        user.setUsername(deleteUserResponse.getUsername());
        return user;
    }

    private User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null)throw new UserDoseNotExist("User Dosen't Exist");
        return user;
    }


    @Override
    public Contact Contact(ContactDto contactDto){
        return contactService.createContact(contactDto);
    }
    @Override
    public Contact updateContact(UpdateContactRequest updateContactRequest){
        return contactService.updateContact(updateContactRequest);
    }
    @Override
    public String deleteContact(DeleteContactRequest username){
        return contactService.deleteContact(username);
    }

    @Override
    public Contact findContactByPhoneNumber(FindContactRequest findContactRequest){
        return contactService.findContactByPhoneNumber(findContactRequest);
    }
    @Override
    public List<Contact> findAllContact(){
        return contactService.findAllContacts();
    }


}
