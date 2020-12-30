package com.shop.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.api.payloads.requests.LoginRequest;
import com.shop.api.payloads.requests.SignupRequest;
import com.shop.api.payloads.responses.JwtResponse;
import com.shop.api.payloads.responses.MessageResponse;
import com.shop.api.services.AuthService;

@CrossOrigin(origins = "https://api-doan.herokuapp.com")
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	@Autowired
	AuthService userService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
		JwtResponse jwt = userService.signin(loginRequest);
		return ResponseEntity.ok(jwt);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
		MessageResponse result = userService.signup(signUpRequest);
		return ResponseEntity.ok(result);
	}
}
