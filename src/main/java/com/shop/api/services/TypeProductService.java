package com.shop.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.api.payloads.requests.TypeProductRequest;
import com.shop.api.payloads.responses.MessageResponse;
import com.shop.api.payloads.responses.TypeProductResponse;

@Service
public interface TypeProductService {
	List<TypeProductResponse> getTypeProducts();
	MessageResponse save(TypeProductRequest typeProductReq);
	MessageResponse delete(String id);

}
