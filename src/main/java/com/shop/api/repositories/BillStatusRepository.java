package com.shop.api.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shop.api.models.BillStatus;
import com.shop.api.models.enums.EBillStatus;

public interface BillStatusRepository extends MongoRepository<BillStatus, String> {
	Optional<BillStatus> findByBillStatus(EBillStatus status);
}
