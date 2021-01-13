package com.shop.api.payloads.requests;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.shop.api.models.BillDetail;

public class BillRequest {
	private String id;
	@NotBlank
	private String username;
	@NotBlank
	private String address;
	@NotBlank
	private String city;
	@NotBlank
	private String phoneNumber;
	@NotBlank
	private Long total;
	@NotBlank
	private List<BillDetail> billDetails;
	@NotBlank
	private String payment;

	public BillRequest() {
		// TODO Auto-generated constructor stub
	}

	public BillRequest(String id, @NotBlank String username, @NotBlank String address, @NotBlank String city,
			@NotBlank String phoneNumber, @NotBlank Long total, @NotBlank List<BillDetail> billDetails,
			@NotBlank String payment) {
		this.id = id;
		this.username = username;
		this.address = address;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.total = total;
		this.billDetails = billDetails;
		this.payment = payment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

}
