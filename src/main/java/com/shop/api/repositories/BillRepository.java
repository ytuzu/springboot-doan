package com.shop.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shop.api.models.Bill;

public interface BillRepository extends MongoRepository<Bill, String> {

}
