package com.shop.api.payloads.responses;

import java.util.List;

public class TypeProductResponse {
	private String id;
	private String label;
	private String code;
	private Boolean isToggle;
	private List<CategoryResponse> leaf;

	public TypeProductResponse() {

	}

	public TypeProductResponse(String id, String label, String code, Boolean isToggle, List<CategoryResponse> leaf) {
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

	public List<CategoryResponse> getLeaf() {
		return leaf;
	}

	public void setLeaf(List<CategoryResponse> leaf) {
		this.leaf = leaf;
	}

}
