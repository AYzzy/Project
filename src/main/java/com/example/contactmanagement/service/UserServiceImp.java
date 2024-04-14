package africaSemicolon.contact4.service;


import africaSemicolon.contact4.dtos.ContactDto;
import africaSemicolon.contact4.dtos.LoginRequest;
import africaSemicolon.contact4.dtos.LogoutRequest;
import africaSemicolon.contact4.dtos.UserRequest;
import africaSemicolon.contact4.data.model.Contact;
import africaSemicolon.contact4.data.model.User;
import africaSemicolon.contact4.data.repository.UserRepository;
import africaSemicolon.contact4.dtos.request.DeleteContactRequest;
import africaSemicolon.contact4.dtos.request.UpdateContactRequest;
import africaSemicolon.contact4.dtos.request.UpdateUserRequest;
import africaSemicolon.contact4.exception.UserNotFoundException;
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
        User user = new User();
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        userRepository.save(user);
        return "successful";

    }

    @Override
    public String login(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        user.setUsername(loginRequest.getUsername());
        user.setPassword(loginRequest.getPassword());
        userRepository.save(user);
        user.setIsLogin(true);
//        if(!user.getUsername().equals(loginRequest.getUsername())) throw new WrongUserName("wrong username");
//        if(!user.getPassword().equals(loginRequest.getPassword())){ throw new WrongUserName("wrong password");}

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
        System.out.println(user);
        user.setUsername(updateContactRequest.getNewUsername());
        user.setPassword(updateContactRequest.getNewPassword());
        System.out.println(user);
        userRepository.save(user);
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
    public Contact findByPhoneNumber(String phoneNumber){
        return contactService.getContact(phoneNumber);
    }
    @Override
    public List<Contact> findAllContact(){
        return contactService.findAllContacts();
    }


}
