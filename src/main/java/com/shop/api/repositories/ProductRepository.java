package com.shop.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shop.api.models.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
