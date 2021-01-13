package com.shop.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.api.models.enums.EBillStatus;
import com.shop.api.payloads.requests.BillRequest;
import com.shop.api.payloads.responses.BillResponse;
import com.shop.api.payloads.responses.MessageResponse;
import com.shop.api.services.BillService;

@CrossOrigin(origins = "https://api-doan.herokuapp.com")
@RestController
@RequestMapping("/api/v1")
public class BillController {
	@Autowired
	private BillService billService;

	@GetMapping("/bills")
	public ResponseEntity<?> getBills() {
		List<BillResponse> message = billService.getBills();
		return ResponseEntity.ok(message);
	}

	@PostMapping("/bills")
	public ResponseEntity<?> createBill(@RequestBody BillRequest billRequest) {
		MessageResponse message = billService.save(billRequest);
		return ResponseEntity.ok(message);
	}

	@PutMapping(value = "/bills/{id}")
	public ResponseEntity<?> updateBill(@RequestBody BillRequest billRequest, @PathVariable(value = "id") String id) {
		billRequest.setId(id);
		MessageResponse message = billService.save(billRequest);
		return ResponseEntity.ok(message);
	}

	@PutMapping(value = "/bills/{id}/{status}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateStatusBill(@PathVariable("id") String id, @PathVariable("status") EBillStatus status) {
		MessageResponse message = billService.updateStatus(id, status);
		return ResponseEntity.ok(message);
	}
	
	@DeleteMapping("/bills/{id}")
	public ResponseEntity<?> deleteBill(@PathVariable("id") String id) {
		MessageResponse message = billService.delete(id);
		return ResponseEntity.ok(message);
	}
	
}
