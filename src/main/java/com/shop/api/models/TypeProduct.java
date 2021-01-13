package com.shop.api.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "typeProducts")
public class TypeProduct {
	@Id
	private String id;
	private String label;
	@Indexed(unique = true)
	private String code;
	private Boolean isToggle;
	private List<Category> leaf;

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

	public List<Category> getLeaf() {
		return leaf;
	}

	public void setLeaf(List<Category> leaf) {
		this.leaf = leaf;
	}

}
