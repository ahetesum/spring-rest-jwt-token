package com.login.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.login.app.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

	@Override
    void delete(Product product);
}
