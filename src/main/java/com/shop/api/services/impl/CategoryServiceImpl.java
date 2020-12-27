package com.shop.api.services.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shop.api.models.Category;
import com.shop.api.payloads.requests.CategoryRequest;
import com.shop.api.payloads.responses.CategoryResponse;
import com.shop.api.payloads.responses.MessageResponse;
import com.shop.api.repositories.CategoryRepository;
import com.shop.api.services.CategoryService;

@Component
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<CategoryResponse> getCategory() {
		List<CategoryResponse> result = new ArrayList<CategoryResponse>();
		for (Category category : categoryRepository.findAll()) {
			CategoryResponse tmp = new CategoryResponse();
			tmp.setId(category.getId());
			tmp.setCode(category.getCode());
			tmp.setName(category.getName());

			result.add(tmp);
		}
		return result;
	}

	@Override
	public MessageResponse save(CategoryRequest categoryReq) {
		Category category;
		if (categoryReq.getId() != null) {
			category = categoryRepository.findById(categoryReq.getId()).orElseThrow(() -> new RuntimeException(categoryReq.getId() + " not exist!"));
		} else {
			category = new Category();
		}
		if ((category.getCode() != null && !category.getCode().equals(categoryReq.getCode())) || category.getCode() == null) {
			if (categoryRepository.existsByCode(categoryReq.getCode())) {
				return new MessageResponse("Code is already taken!");
			}
		}

		category.setCode(categoryReq.getCode());
		category.setName(categoryReq.getName());

		categoryRepository.save(category);
		return new MessageResponse("Successfully!");
	}

	@Override
	public MessageResponse delete(String id) {
		Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " not exist!"));
		categoryRepository.delete(category);
		return new MessageResponse("Delete successfully!");
	}
}
