package com.shop.api.payloads.requests;

import java.util.List;

import javax.validation.constraints.NotBlank;

public class ProductRequest {
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
	private double prices;

	@NotBlank
	private int quantities;

	@NotBlank
	private String description;

	@NotBlank
	private String typeColor;

	@NotBlank
	private String status;

	@NotBlank
	private List<String> typeCategory;

	public ProductRequest() {
	}

	public ProductRequest(String id, String imgUrl_hover, String imgUrl,
			String nameProduct, List<String> img_Thumb, String productStatus,
			double prices, int quantities, String description, String typeColor,
			String status, List<String> typeCategory) {
		this.id = id;
		this.imgUrl_hover = imgUrl_hover;
		this.imgUrl = imgUrl;
		this.nameProduct = nameProduct;
		this.img_Thumb = img_Thumb;
		this.productStatus = productStatus;
		this.prices = prices;
		this.quantities = quantities;
		this.description = description;
		this.typeColor = typeColor;
		this.status = status;
		this.typeCategory = typeCategory;
	}

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

	public double getPrices() {
		return prices;
	}

	public void setPrices(double prices) {
		this.prices = prices;
	}

	public int getQuantities() {
		return quantities;
	}

	public void setQuantities(int quantities) {
		this.quantities = quantities;
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

	public List<String> getTypeCategory() {
		return typeCategory;
	}

	public void setTypeCategory(List<String> typeCategory) {
		this.typeCategory = typeCategory;
	}

}
