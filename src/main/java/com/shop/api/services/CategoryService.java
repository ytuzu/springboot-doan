package com.shop.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.api.payloads.requests.CategoryRequest;
import com.shop.api.payloads.responses.CategoryResponse;
import com.shop.api.payloads.responses.MessageResponse;

@Service
public interface CategoryService {
	MessageResponse save(CategoryRequest req);
	List<CategoryResponse> getCategory();
	MessageResponse delete(String id);

}
