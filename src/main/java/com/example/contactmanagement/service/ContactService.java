package africaSemicolon.contact4.service;

import africaSemicolon.contact4.dtos.ContactDto;
import africaSemicolon.contact4.data.model.Contact;
import africaSemicolon.contact4.dtos.request.DeleteContactRequest;
import africaSemicolon.contact4.dtos.request.UpdateContactRequest;

import java.util.List;

public interface ContactService {

        Contact createContact(ContactDto contactDto);
        Contact updateContact(UpdateContactRequest updateContactRequest);
        String deleteContact(DeleteContactRequest deleteContactRequest);
        Contact getContact(String username);
        List<Contact> findAllContacts();


}
