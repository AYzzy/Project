package com.example.contactmanagement.service;



import com.example.contactmanagement.data.model.Contact;

import com.example.contactmanagement.data.repository.ContactRepository;
import com.example.contactmanagement.dtos.ContactDto;
import com.example.contactmanagement.dtos.GetContactRequest;
import com.example.contactmanagement.dtos.reponse.ContactDtoResponse;
import com.example.contactmanagement.dtos.reponse.UpdateContactResponse;
import com.example.contactmanagement.dtos.request.DeleteContactRequest;
import com.example.contactmanagement.dtos.request.FindContactRequest;
import com.example.contactmanagement.dtos.request.UpdateContactRequest;
import com.example.contactmanagement.exception.ContactNotFound;
import com.example.contactmanagement.exception.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact createContact(ContactDto contactDto) {
        for(Contact contact : contactRepository.findAll()) {
            if (contact.getFirstName().equals(contactDto.getFirstName()) && contact.getPhoneNumber().equals(contactDto.getPhoneNumber())) {
                throw new UserAlreadyExistException("Existing Contact");
            }
        }
        Contact contact = new Contact();
        contact.setFirstName(contactDto.getFirstName());
        contact.setLastName(contactDto.getLastName());
        contact.setEmail(contactDto.getEmail());
        contact.setPhoneNumber(contactDto.getPhoneNumber());
        contactRepository.save(contact);

        ContactDtoResponse contactDtoResponse = new ContactDtoResponse();
        contactDtoResponse.setFirstName(contactDtoResponse.getFirstName());
        contactDtoResponse.setLastName(contactDtoResponse.getLastName());
        contactDtoResponse.setEmail(contactDtoResponse.getEmail());
        contactDtoResponse.setPhoneNumber(contactDtoResponse.getPhoneNumber());

        return contact;
    }
                    
    @Override
    public Contact updateContact(UpdateContactRequest updatedContactDto) {
        Contact existingContact = contactRepository.findContactByPhoneNumber(updatedContactDto.getPhoneNumber());
        existingContact.setFirstName(updatedContactDto.getNewFirstName());
        existingContact.setLastName(updatedContactDto.getNewLastName());
        existingContact.setEmail(updatedContactDto.getNewEmail());
        existingContact.setPhoneNumber(updatedContactDto.getNewPhoneNumber());
        contactRepository.save(existingContact);

        UpdateContactResponse updateContactResponse = new UpdateContactResponse();
        updateContactResponse.setFirstName(updateContactResponse.getNewFirstName());
        updateContactResponse.setLastName(updatedContactDto.getNewLastName());
        updateContactResponse.setEmail(updateContactResponse.getNewEmail());
        updateContactResponse.setPhoneNumber(updateContactResponse.getNewPhoneNumber());
        return existingContact;
    }

    @Override
    public String deleteContact(DeleteContactRequest deleteContactRequest) {
        Contact contact = getContact(deleteContactRequest.getUsername());
        contactRepository.delete(contact);
        return "Deleted Successfully.";
    }

    private Contact getContact(String phoneNumber) {
        Contact contact = contactRepository.findContactByPhoneNumber(phoneNumber);
        if(contact == null)throw new ContactNotFound("This number doesnt exist");
        return contact;
    }

    @Override
    public Contact findContactByPhoneNumber(FindContactRequest findContactRequest) {
        Contact contact = getContact(findContactRequest.getPhoneNumber());
        contactRepository.findContactByPhoneNumber(findContactRequest.getPhoneNumber());
        FindContactRequest findContactRequest1 = new FindContactRequest();
        contact.setPhoneNumber(findContactRequest1.getPhoneNumber());
        return contact;
    }


    @Override
    public List<Contact> findAllContacts() {
        return contactRepository.findAll();
    }




}

