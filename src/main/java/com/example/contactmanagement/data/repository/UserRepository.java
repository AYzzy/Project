package com.example.contactmanagement.data.repository;


import com.example.contactmanagement.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);

    boolean existsByUsername(String username);

}
