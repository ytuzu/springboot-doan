package com.shop.api.payloads.responses;

import java.util.List;

import com.shop.api.models.BillDetail;

public class BillResponse {
	private String id;
	private String user;
	private String address;
	private String city;
	private String phoneNumber;
	private Long total;
	private List<BillDetail> billDetails;
	private String payment;
	private String status;

	public BillResponse() {

	}

	public BillResponse(String id, String user, String address, String city, String phoneNumber, Long total,
			List<BillDetail> billDetails, String payment, String status) {
		this.id = id;
		this.user = user;
		this.address = address;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.total = total;
		this.billDetails = billDetails;
		this.payment = payment;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<BillDetail> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(List<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
