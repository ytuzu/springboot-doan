package com.shop.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@CrossOrigin(origins = "https://api-doan.herokuapp.com")
@RestController
@RequestMapping
public class DocumentController {
	@GetMapping({"/doc","/", "/document"})
	public @ResponseBody Object documentShow() {
		Resource resource = new ClassPathResource("/static/json/document.json");
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(resource.getInputStream(), Object.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
	}
}
