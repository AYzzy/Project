package com.example.contactmanagement.service;

import com.example.contactmanagement.data.repository.ContactRepository;
import com.example.contactmanagement.data.repository.UserRepository;
import com.example.contactmanagement.dtos.ContactDto;
import com.example.contactmanagement.dtos.LoginRequest;
import com.example.contactmanagement.dtos.LogoutRequest;
import com.example.contactmanagement.dtos.UserRequest;
import com.example.contactmanagement.dtos.request.DeleteContactRequest;
import com.example.contactmanagement.dtos.request.DeleteUserRequest;
import com.example.contactmanagement.dtos.request.UpdateUserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class UserServiceImpTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @BeforeEach
    public void setUp(){
        userRepository.deleteAll();
    }


    @Test
    void register() {

        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName("ayo");
        userRequest.setLastName("ddd");
        userRequest.setUsername("the boy");
        userRequest.setPassword("223344");
        userService.register(userRequest);
        assertEquals(1, userRepository.count());
    }

    @Test
    void login() {
        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName("ayo");
        userRequest.setLastName("ddd");
        userRequest.setUsername("username");
        userRequest.setPassword("223344");
        userService.register(userRequest);
        assertEquals(1, userRepository.count());
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("223344");
        userService.login(loginRequest);
        assertTrue(userRepository.findByUsername(loginRequest.getUsername()).getIsLogin());
    }

    @Test
    void logout() {
        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName("ayo");
        userRequest.setLastName("ddd");
        userRequest.setUsername("username");
        userRequest.setPassword("223344");
        userService.register(userRequest);
        assertEquals(1, userRepository.count());
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("223344");
        userService.login(loginRequest);
        assertTrue(userRepository.findByUsername(loginRequest.getUsername()).getIsLogin());
        LogoutRequest logoutRequest = new LogoutRequest();
        logoutRequest.setUsername("username");
        userService.logout(logoutRequest);
        assertFalse(userRepository.findByUsername(loginRequest.getUsername()).getIsLogin());
    }

    @Test
    void update() {
        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName("ayo");
        userRequest.setLastName("ddd");
        userRequest.setUsername("username");
        userRequest.setPassword("223344");
        userService.register(userRequest);
        assertEquals(1, userRepository.count());
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("223344");
        userService.login(loginRequest);
        assertTrue(userRepository.findByUsername(loginRequest.getUsername()).getIsLogin());
        UpdateUserRequest updateUserRequest = new UpdateUserRequest();
        updateUserRequest.setUsername("username");
        updateUserRequest.setPassword("223344");
        updateUserRequest.setNewPassword("mememe");
        updateUserRequest.setNewPassword("11223344");
        userService.update(updateUserRequest);
        assertEquals(1,userRepository.count());

    }
    @Test
    void deleteAccount(){
        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName("ayo");
        userRequest.setLastName("ddd");
        userRequest.setUsername("username");
        userRequest.setPassword("223344");
        userService.register(userRequest);
        assertEquals(1, userRepository.count());
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("223344");
        userService.login(loginRequest);
        assertTrue(userRepository.findByUsername(loginRequest.getUsername()).getIsLogin());
        DeleteUserRequest deleteUserRequest = new DeleteUserRequest();
        deleteUserRequest.setUsername("username");
        userService.delete(deleteUserRequest);
        assertEquals(0, userRepository.count());
    }

}