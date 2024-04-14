package africaSemicolon.contact4.service;


import africaSemicolon.contact4.dtos.ContactDto;
import africaSemicolon.contact4.data.model.Contact;
import africaSemicolon.contact4.data.repository.ContactRepository;
import africaSemicolon.contact4.dtos.reponse.ContactDtoResponse;
import africaSemicolon.contact4.dtos.request.DeleteContactRequest;
import africaSemicolon.contact4.dtos.request.UpdateContactRequest;
import africaSemicolon.contact4.exception.ContactNotFound;
import africaSemicolon.contact4.exception.UserAlreadyExistException;

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
        Contact existingContact = contactRepository.findContact(updatedContactDto.getFirstName());
        existingContact.setFirstName(updatedContactDto.getNewFirstName());
        existingContact.setLastName(updatedContactDto.getNewLastName());
        existingContact.setEmail(updatedContactDto.getNewEmail());
        existingContact.setPhoneNumber(updatedContactDto.getNewPhoneNumber());
        Contact updatedContact = contactRepository.save(existingContact);
        return existingContact;
    }

    @Override
    public String deleteContact(DeleteContactRequest deleteContactRequest) {
        Contact contact = getContact(deleteContactRequest.getUsername());
        contactRepository.delete(contact);
        return "Deleted Successfully.";
    }
    @Override
    public Contact getContact(String username) {
        Contact contact = contactRepository.findContact(username);
        if(contact == null)throw new ContactNotFound("This number doesnt exist");
        return contact;
    }

    @Override
    public List<Contact> findAllContacts() {
        return contactRepository.findAll();
    }




}

