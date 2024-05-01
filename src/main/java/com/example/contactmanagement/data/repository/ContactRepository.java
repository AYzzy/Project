package com.example.contactmanagement.data.repository;

import com.example.contactmanagement.data.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface ContactRepository extends MongoRepository<Contact, String> {

    Contact findContactByPhoneNumber(String phoneNumber);

}
