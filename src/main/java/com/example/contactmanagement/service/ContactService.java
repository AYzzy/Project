package com.example.contactmanagement.service;



import com.example.contactmanagement.data.model.Contact;
import com.example.contactmanagement.dtos.ContactDto;
import com.example.contactmanagement.dtos.request.DeleteContactRequest;
import com.example.contactmanagement.dtos.request.FindContactRequest;
import com.example.contactmanagement.dtos.request.UpdateContactRequest;

import java.util.List;

public interface ContactService {

        Contact createContact(ContactDto contactDto);
        Contact updateContact(UpdateContactRequest updateContactRequest);
        String deleteContact(DeleteContactRequest deleteContactRequest);
//        Contact getContact(String phoneNumber);
        Contact findContactByPhoneNumber(FindContactRequest findContactRequest);
        List<Contact> findAllContacts();


}
