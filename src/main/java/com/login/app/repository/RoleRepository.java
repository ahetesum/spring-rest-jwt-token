package com.login.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.login.app.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByRole(String role);
}
