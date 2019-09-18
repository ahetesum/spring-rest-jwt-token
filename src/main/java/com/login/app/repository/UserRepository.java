package com.login.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.login.app.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
