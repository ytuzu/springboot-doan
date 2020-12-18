package com.shop.api.services;

import org.springframework.stereotype.Service;

import com.shop.api.payloads.requests.LoginRequest;
import com.shop.api.payloads.requests.SignupRequest;
import com.shop.api.payloads.responses.JwtResponse;
import com.shop.api.payloads.responses.MessageResponse;


@Service
public interface AuthService {
	JwtResponse signin(LoginRequest loginRequest);
	MessageResponse signup(SignupRequest signUpRequest);
}
