package com.shop.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.api.payloads.requests.ProductRequest;
import com.shop.api.payloads.responses.MessageResponse;
import com.shop.api.payloads.responses.ProductResponse;

@Service
public interface ProductService {
	List<ProductResponse> getProducts();
	MessageResponse save(ProductRequest productReq);
	MessageResponse delete(String id);
	ProductResponse getProductById(String id);
}
