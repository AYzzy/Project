package africaSemicolon.contact4.data.repository;

import africaSemicolon.contact4.data.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {
    Contact findContact(String username);

    Contact findByFirstName(String firstName);

}
