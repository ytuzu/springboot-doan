package com.shop.api.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shop.api.models.ERole;
import com.shop.api.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	Optional<Role> findByName(ERole name);
}