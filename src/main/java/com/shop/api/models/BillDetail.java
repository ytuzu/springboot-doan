package com.shop.api.models;

public class BillDetail {
	private String productID;
	private double prices;
	private int quantity;
	private double totalProduct;

	public BillDetail() {
	}

	public BillDetail(String productID, double prices, int quantity, double totalProduct) {
		this.productID = productID;
		this.prices = prices;
		this.quantity = quantity;
		this.totalProduct = totalProduct;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public double getPrices() {
		return prices;
	}

	public void setPrices(double prices) {
		this.prices = prices;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalProduct() {
		return totalProduct;
	}

	public void setTotalProduct(double totalProduct) {
		this.totalProduct = totalProduct;
	}

}
