package com.shop.api.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.shop.api.models.ERole;
import com.shop.api.models.Role;
import com.shop.api.models.User;
import com.shop.api.payloads.requests.LoginRequest;
import com.shop.api.payloads.requests.SignupRequest;
import com.shop.api.payloads.responses.JwtResponse;
import com.shop.api.payloads.responses.MessageResponse;
import com.shop.api.repositories.RoleRepository;
import com.shop.api.repositories.UserRepository;
import com.shop.api.security.jwt.JwtUtils;
import com.shop.api.security.services.UserDetailsImpl;
import com.shop.api.services.AuthService;

@Component
public class AuthServiceImpl implements AuthService{
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Override
	public JwtResponse signin(LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginRequest.getUsername().toLowerCase(), loginRequest.getPassword().toLowerCase()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles);
	}

	@Override
	public MessageResponse signup(SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new MessageResponse("Username is already taken!");
		}
		
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new MessageResponse("Email is already taken!");
		}
		
		// Create new user's account
		User user = new User(
				signUpRequest.getUsername().toLowerCase(), 
				signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword().toLowerCase()));

		Set<String> strRoles = signUpRequest.getRoles();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			for (String role : strRoles) {
				if (role.equals("ROLE_ADMIN")) {
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);		
				}
				else if (role.equals("ROLE_USER")){
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				} 
				else if (role.equals("ROLE_MODERATOR")){
					Role userRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				} else {
					return new MessageResponse("Error: Role is not found.");
				}
			}
			
			
		}

		user.setRoles(roles);
		userRepository.save(user);
		return new MessageResponse("User registered successfully!");
	}

}
