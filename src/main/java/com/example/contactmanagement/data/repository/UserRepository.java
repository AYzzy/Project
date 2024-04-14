package africaSemicolon.contact4.data.repository;

import africaSemicolon.contact4.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
