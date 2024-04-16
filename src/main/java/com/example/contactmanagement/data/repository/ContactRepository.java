package africaSemicolon.data.repository;

import africaSemicolon.data.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface ContactRepository extends MongoRepository<Contact, String> {
    Contact findContact(String username);

}
