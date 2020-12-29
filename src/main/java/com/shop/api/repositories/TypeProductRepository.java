package com.shop.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shop.api.models.TypeProduct;

public interface TypeProductRepository extends MongoRepository<TypeProduct, String> {
	boolean existsByCode(String code);
}
