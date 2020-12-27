package com.shop.api.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shop.api.models.Category;
import com.shop.api.models.Product;
import com.shop.api.payloads.requests.ProductRequest;
import com.shop.api.payloads.responses.MessageResponse;
import com.shop.api.payloads.responses.ProductResponse;
import com.shop.api.repositories.CategoryRepository;
import com.shop.api.repositories.ProductRepository;
import com.shop.api.services.ProductService;

@Component
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<ProductResponse> getProducts() {
		List<ProductResponse> result = new ArrayList<ProductResponse>();
		for (Product product : productRepository.findAll()) {
			ProductResponse tmp = new ProductResponse();
			tmp.setId(product.getId());
			tmp.setDescription(product.getDescription());
			tmp.setImg_Thumb(product.getImg_Thumb());
			tmp.setImgUrl(product.getImgUrl());
			tmp.setImgUrl_hover(product.getImgUrl_hover());
			tmp.setNameProduct(product.getNameProduct());
			tmp.setPrices(product.getPrices());
			tmp.setProductStatus(product.getStatus());
			tmp.setQuantities(product.getQuantity());
			tmp.setStatus(product.getStatus());
			
			// Set typeCategories for tmp
			List<String> typeCategories = new ArrayList<String>();
			for (Category category : product.getTypeCategory()) {
				typeCategories.add(category.getCode());
			}
			tmp.setTypeCategory(typeCategories);
			
			tmp.setTypeColor(product.getTypeColor());
			
			result.add(tmp);
		}
		return result;
	}

	@Override
	public MessageResponse save(ProductRequest productReq) {
		Product product;
		if (productReq.getId() != null) {
			product = productRepository.findById(productReq.getId()).orElseThrow(() -> new RuntimeException(productReq.getId() + " not exist!"));
		} else {
			product = new Product();
		}
		
		product.setDescription(productReq.getDescription());
		product.setImg_Thumb(productReq.getImg_Thumb());
		product.setImgUrl(productReq.getImgUrl());
		product.setImgUrl_hover(productReq.getImgUrl_hover());
		product.setNameProduct(productReq.getNameProduct());
		product.setPrices(productReq.getPrices());
		product.setProductStatus(productReq.getStatus());
		product.setQuantity(productReq.getQuantities());
		product.setStatus(productReq.getStatus());
		
		// Set typeCategories
		List<Category> typeCategories = new ArrayList<Category>();
		for (String categoryCode : productReq.getTypeCategory()) {
			typeCategories.add(categoryRepository.findOneByCode(categoryCode).orElseThrow(() -> new RuntimeException(categoryCode + " not exist! ")));
		}
		product.setTypeCategory(typeCategories);
		
		product.setTypeColor(productReq.getTypeColor());
		
		productRepository.save(product);
		return new MessageResponse("Successfully!");
	}

	@Override
	public MessageResponse delete(String id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " not exist!"));
		productRepository.delete(product);
		return new MessageResponse("Delete successfully!");
	}
}
