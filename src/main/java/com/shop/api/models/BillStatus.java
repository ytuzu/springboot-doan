package com.shop.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.shop.api.models.enums.EBillStatus;

@Document(collection = "billstatus")
public class BillStatus {
	@Id
	private String id;
	private EBillStatus billStatus;

	public BillStatus() {

	}

	public BillStatus(String id, EBillStatus billStatus) {
		this.id = id;
		this.billStatus = billStatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EBillStatus getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(EBillStatus billStatus) {
		this.billStatus = billStatus;
	}

}
