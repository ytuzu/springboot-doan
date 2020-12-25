package com.shop.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shop.api.models.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

	boolean existsByCode(String code);
	
}
