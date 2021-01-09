package com.shop.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.api.payloads.requests.ProductRequest;
import com.shop.api.payloads.responses.MessageResponse;
import com.shop.api.payloads.responses.ProductResponse;
import com.shop.api.services.ProductService;

@CrossOrigin(origins = "https://api-doan.herokuapp.com")
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public ResponseEntity<?> getProducts() {
		List<ProductResponse> message = productService.getProducts();
		return ResponseEntity.ok(message);
	}

	@GetMapping("/product")
	public ResponseEntity<?> getProductById(@RequestParam String id) {
		ProductResponse message = productService.getProductById(id);
		return ResponseEntity.ok(message);
	}
	
	@PostMapping("/products")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createProduct(@RequestBody ProductRequest productReq) {
		MessageResponse message = productService.save(productReq);
		return ResponseEntity.ok(message);
	}

	@PutMapping("/products")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateProduct(@RequestBody ProductRequest productReq, @RequestParam String id) {
		productReq.setId(id);
		MessageResponse message = productService.save(productReq);
		return ResponseEntity.ok(message);
	}

	@DeleteMapping("/products")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateProduct(@RequestParam String id) {
		MessageResponse message = productService.delete(id);
		return ResponseEntity.ok(message);
	}
}
