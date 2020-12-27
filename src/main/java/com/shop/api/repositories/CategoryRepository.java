package com.shop.api.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shop.api.models.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {
	boolean existsByCode(String code);
	Optional<Category> findOneByCode(String code);
}
