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

import com.shop.api.payloads.requests.CategoryRequest;
import com.shop.api.payloads.responses.CategoryResponse;
import com.shop.api.payloads.responses.MessageResponse;
import com.shop.api.services.CategoryService;

@CrossOrigin(origins = "https://api-doan.herokuapp.com")
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/categories")
	public ResponseEntity<?> getCategories() {
		List<CategoryResponse> message = categoryService.getCategory();
		return ResponseEntity.ok(message);
	}

	@PostMapping("/categories")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createCategory(@RequestBody CategoryRequest categoryReq) {
		MessageResponse message = categoryService.save(categoryReq);
		return ResponseEntity.ok(message);
	}

	@PutMapping("/categories")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateCategory(@RequestBody CategoryRequest categoryReq, @RequestParam("id") String id) {
		categoryReq.setId(id);
		MessageResponse message = categoryService.save(categoryReq);
		return ResponseEntity.ok(message);
	}

	@DeleteMapping("/categories")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteCategory(@RequestParam("id") String id) {
		MessageResponse message = categoryService.delete(id);
		return ResponseEntity.ok(message);
	}
}
