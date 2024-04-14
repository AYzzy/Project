package africaSemicolon.contact4.service;

import africaSemicolon.contact4.dtos.ContactDto;
import africaSemicolon.contact4.dtos.LoginRequest;
import africaSemicolon.contact4.dtos.LogoutRequest;
import africaSemicolon.contact4.dtos.UserRequest;
import africaSemicolon.contact4.data.model.Contact;
import africaSemicolon.contact4.dtos.request.DeleteContactRequest;
import africaSemicolon.contact4.dtos.request.UpdateContactRequest;
import africaSemicolon.contact4.dtos.request.UpdateUserRequest;

import java.util.List;

public interface UserService {

    String register(UserRequest userRequest);

    String login(LoginRequest loginRequest);
    String logout(LogoutRequest logoutRequest);
    void update(UpdateUserRequest updateContactRequest);

    Contact Contact(ContactDto contactDto);

    Contact updateContact(UpdateContactRequest updateContactRequest);

    String deleteContact(DeleteContactRequest username);

    Contact findByPhoneNumber(String phoneNumber);

    List<Contact> findAllContact();
}
