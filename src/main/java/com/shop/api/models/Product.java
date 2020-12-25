package com.shop.api.models;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
	@Id
	private String id;

	@NotBlank
	private String imgUrl_hover;

	@NotBlank
	private String imgUrl;

	@NotBlank
	private String nameProduct;

	@NotBlank
	private List<String> img_Thumb;

	@NotBlank
	private String productStatus;

	@NotBlank
	private int quantity;

	@NotBlank
	private String description;

	@NotBlank
	private String typeColor;

	@NotBlank
	private String status;

	@NotBlank
	private List<Category> typeCategory;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImgUrl_hover() {
		return imgUrl_hover;
	}

	public void setImgUrl_hover(String imgUrl_hover) {
		this.imgUrl_hover = imgUrl_hover;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public List<String> getImg_Thumb() {
		return img_Thumb;
	}

	public void setImg_Thumb(List<String> img_Thumb) {
		this.img_Thumb = img_Thumb;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTypeColor() {
		return typeColor;
	}

	public void setTypeColor(String typeColor) {
		this.typeColor = typeColor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Category> getTypeCategory() {
		return typeCategory;
	}

	public void setTypeCategory(List<Category> typeCategory) {
		this.typeCategory = typeCategory;
	}

}
