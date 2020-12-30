package com.shop.api.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shop.api.models.Category;
import com.shop.api.models.TypeProduct;
import com.shop.api.payloads.requests.TypeProductRequest;
import com.shop.api.payloads.responses.CategoryResponse;
import com.shop.api.payloads.responses.MessageResponse;
import com.shop.api.payloads.responses.TypeProductResponse;
import com.shop.api.repositories.CategoryRepository;
import com.shop.api.repositories.TypeProductRepository;
import com.shop.api.services.TypeProductService;

@Component
public class TypeProductServiceImpl implements TypeProductService {

	@Autowired
	private TypeProductRepository typeProductRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<TypeProductResponse> getTypeProducts() {
		List<TypeProductResponse> results = new ArrayList<TypeProductResponse>();
		for (TypeProduct typeProduct : typeProductRepository.findAll()) {
			TypeProductResponse tmp = new TypeProductResponse();
			tmp.setId(typeProduct.getId());
			tmp.setCode(typeProduct.getCode());
			tmp.setIsToggle(typeProduct.getIsToggle());
			tmp.setLabel(typeProduct.getLabel());
			
			// Set leaf
			List<CategoryResponse> categoryResponses = new ArrayList<CategoryResponse>();
			for (Category category : typeProduct.getLeaf()) {
				CategoryResponse categoryResponse = new CategoryResponse(category.getId(), category.getCode(), category.getName());
				
				categoryResponses.add(categoryResponse);
			}
			tmp.setLeaf(categoryResponses);
			
			results.add(tmp);
		}
		return results;
	}

	@Override
	public MessageResponse save(TypeProductRequest typeProductReq) {
		TypeProduct typeProduct;
		if (typeProductReq.getId() != null) {
			typeProduct =  typeProductRepository.findById(typeProductReq.getId()).orElseThrow(() -> new RuntimeException(typeProductReq.getId() + " not exist!"));
		} else {
			typeProduct = new TypeProduct();
		}

		if ((typeProduct.getCode() != null && !typeProduct.getCode().equals(typeProductReq.getCode())) || typeProduct.getCode() == null) {
			if (categoryRepository.existsByCode(typeProductReq.getCode())) {
				return new MessageResponse(typeProductReq.getCode() + " not exist!");
			}
		}
		typeProduct.setLabel(typeProductReq.getLabel());
		typeProduct.setCode(typeProductReq.getCode());
		typeProduct.setIsToggle(typeProductReq.getIsToggle());
		
		List<Category> categories = new ArrayList<Category>();
		for (String categoryCode : typeProductReq.getLeaf()) {
			Category category = categoryRepository.findOneByCode(categoryCode).orElseThrow(() -> new RuntimeException(categoryCode + " not exist!"));
			categories.add(category);
		}
		typeProduct.setLeaf(categories);
		typeProductRepository.save(typeProduct);
		return new MessageResponse("Successfully!");
	}

	@Override
	public MessageResponse delete(String id) {
		typeProductRepository.deleteById(id);
		return new MessageResponse("Delete successsfully!");
	}
	
}
