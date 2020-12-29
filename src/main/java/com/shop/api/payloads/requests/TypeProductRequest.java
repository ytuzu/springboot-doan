package com.shop.api.payloads.requests;

import java.util.List;

import javax.validation.constraints.NotBlank;

public class TypeProductRequest {
	private String id;
	@NotBlank
	private String label;
	@NotBlank
	private String code;
	@NotBlank
	private Boolean isToggle;
	@NotBlank
	private List<CategoryRequest> leaf;

	public TypeProductRequest() {
	}

	public TypeProductRequest(String id, String label, String code, Boolean isToggle, List<CategoryRequest> leaf) {
		this.id = id;
		this.label = label;
		this.code = code;
		this.isToggle = isToggle;
		this.leaf = leaf;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getIsToggle() {
		return isToggle;
	}

	public void setIsToggle(Boolean isToggle) {
		this.isToggle = isToggle;
	}

	public List<CategoryRequest> getLeaf() {
		return leaf;
	}

	public void setLeaf(List<CategoryRequest> leaf) {
		this.leaf = leaf;
	}

}
