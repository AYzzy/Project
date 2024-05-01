package com.example.contactmanagement.service;

import com.example.contactmanagement.data.repository.ContactRepository;
import com.example.contactmanagement.dtos.ContactDto;
import com.example.contactmanagement.dtos.GetContactRequest;
import com.example.contactmanagement.dtos.request.DeleteContactRequest;
import com.example.contactmanagement.dtos.request.UpdateContactRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ContactServiceImplTest {
    @Autowired
    private ContactService contactService;
    @Autowired
    private ContactRepository contactRepository;
    @BeforeEach
    public void setUp(){
        contactRepository.deleteAll();
    }

    @Test
    void createContact() {
        ContactDto contactRequest = new ContactDto();
        contactRequest.setFirstName("username");
        contactRequest.setLastName("ayo");
        contactRequest.setEmail("ay@gmail");
        contactRequest.setPhoneNumber("090949494");
        contactService.createContact(contactRequest);
        assertEquals(1, contactRepository.count());
    }

    @Test
    void updateContact() {
        ContactDto contactRequest = new ContactDto();
        contactRequest.setFirstName("username");
        contactRequest.setLastName("ayo");
        contactRequest.setEmail("ay@gmail");
        contactRequest.setPhoneNumber("090949494");
        contactService.createContact(contactRequest);
        assertEquals(1, contactRepository.count());
        UpdateContactRequest updateContactRequest = new UpdateContactRequest();
        updateContactRequest.setFirstName("username");
        updateContactRequest.setLastName("ayo");
        updateContactRequest.setEmail("ay@gmail");
        updateContactRequest.setPhoneNumber("090949494");
        updateContactRequest.setNewFirstName("ayo");
        updateContactRequest.setNewLastName("mide");
        updateContactRequest.setNewEmail("theboy@gmail.com");
        updateContactRequest.setNewPhoneNumber("08134191939");
        contactService.updateContact(updateContactRequest);
        assertEquals(1,contactRepository.count());
    }

    @Test
    void deleteContact() {
        ContactDto contactRequest = new ContactDto();
        contactRequest.setFirstName("username");
        contactRequest.setLastName("ayo");
        contactRequest.setEmail("ay@gmail");
        contactRequest.setPhoneNumber("090949494");
        contactService.createContact(contactRequest);
        assertEquals(1, contactRepository.count());
        ContactDto contactRequest1 = new ContactDto();
        contactRequest1.setFirstName("ayo");
        contactRequest1.setLastName("mide");
        contactRequest1.setEmail("ay0798@gmail");
        contactRequest1.setPhoneNumber("090829579");
        contactService.createContact(contactRequest1);
        assertEquals(2, contactRepository.count());
        DeleteContactRequest deleteContactRequest = new DeleteContactRequest();
        deleteContactRequest.setUsername(contactRequest1.getPhoneNumber());
        contactService.deleteContact(deleteContactRequest);
        assertEquals(1,contactRepository.count());
    }
    @Test
    void findContact(){
        ContactDto contactRequest = new ContactDto();
        contactRequest.setFirstName("username");
        contactRequest.setLastName("ayo");
        contactRequest.setEmail("ay@gmail");
        contactRequest.setPhoneNumber("090949494");
        contactService.createContact(contactRequest);
        assertEquals(1, contactRepository.count());
        ContactDto contactRequest1 = new ContactDto();
        contactRequest1.setFirstName("ayo");
        contactRequest1.setLastName("mide");
        contactRequest1.setEmail("ay0798@gmail");
        contactRequest1.setPhoneNumber("090829579");
        contactService.createContact(contactRequest1);
        assertEquals(2, contactRepository.count());

    }
}
