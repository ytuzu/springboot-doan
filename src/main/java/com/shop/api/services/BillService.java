package com.shop.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.api.models.enums.EBillStatus;
import com.shop.api.payloads.requests.BillRequest;
import com.shop.api.payloads.responses.BillResponse;
import com.shop.api.payloads.responses.MessageResponse;

@Service
public interface BillService {

	List<BillResponse> getBills();

	MessageResponse save(BillRequest billRequest);

	MessageResponse delete(String id);

	MessageResponse updateStatus(String id, EBillStatus status);

}
