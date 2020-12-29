package com.shop.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.api.payloads.requests.TypeProductRequest;
import com.shop.api.payloads.responses.MessageResponse;
import com.shop.api.payloads.responses.TypeProductResponse;
import com.shop.api.services.TypeProductService;

@RestController
@RequestMapping("/api/v1/typeproduct")
public class TypeProductController {
	@Autowired
	private TypeProductService typeProductService;
	
	@GetMapping("/products")
	public ResponseEntity<?> getCategories() {
		List<TypeProductResponse> message = typeProductService.getTypeProducts();
		return ResponseEntity.ok(message);
	}
	
	@PostMapping("/products")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createCategory(@RequestBody TypeProductRequest typeProductReq) {
		MessageResponse message = typeProductService.save(typeProductReq);
		return ResponseEntity.ok(message);
	}
	
	@PutMapping("/products")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateCategory(@RequestBody TypeProductRequest typeProductReq, @RequestParam String id) {
		typeProductReq.setId(id);
		MessageResponse message = typeProductService.save(typeProductReq);
		return ResponseEntity.ok(message);
	}
	
	@DeleteMapping("/products")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateCategory(@RequestParam String id) {
		MessageResponse message = typeProductService.delete(id);
		return ResponseEntity.ok(message);
	}
}
