package com.shop.api.payloads.requests;

import javax.validation.constraints.NotBlank;

public class CategoryRequest {
	private String id;

	@NotBlank
	private String code;

	@NotBlank
	private String name;

	public CategoryRequest() {
	}

	public CategoryRequest(String id, String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
