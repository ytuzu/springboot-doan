package com.shop.api.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.shop.api.models.Bill;
import com.shop.api.models.BillDetail;
import com.shop.api.models.Product;
import com.shop.api.models.enums.EBillStatus;
import com.shop.api.payloads.requests.BillRequest;
import com.shop.api.payloads.responses.BillResponse;
import com.shop.api.payloads.responses.MessageResponse;
import com.shop.api.repositories.BillRepository;
import com.shop.api.repositories.BillStatusRepository;
import com.shop.api.repositories.ProductRepository;
import com.shop.api.repositories.UserRepository;
import com.shop.api.services.BillService;

@Component
public class BillServiceImpl implements BillService {
	@Autowired
	private BillRepository billRepository;

	@Autowired
	private BillStatusRepository billStatusRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<BillResponse> getBills() {
		List<Bill> bills = billRepository.findAll();
		List<BillResponse> result = new ArrayList<BillResponse>();
		for (Bill bill : bills) {
			BillResponse billResponse = new BillResponse();
			billResponse.setId(bill.getId());
			billResponse.setAddress(bill.getAddress());
			billResponse.setCity(bill.getCity());
			billResponse.setPayment(bill.getPayment());
			billResponse.setPhoneNumber(bill.getPhoneNumber());
			billResponse.setTotal(bill.getTotal());
			billResponse.setUser(bill.getUser().getUsername());
			billResponse.setStatus(bill.getStatus().getBillStatus().toString());
			billResponse.setBillDetails(bill.getBillDetails());

			result.add(billResponse);
		}
		return result;
	}

	@Override
	@Transactional
	public MessageResponse save(BillRequest billRequest) {
		Bill bill = null;
		Date now = new Date(System.currentTimeMillis());
		String username = billRequest.getUsername();
		String billID = billRequest.getId();

		if (billID != null) {
			bill = billRepository.findById(billID).orElseThrow(() -> new RuntimeException(billID + " not exist!"));
			bill.setUpdatedDate(now);
			bill.setUpdatedBy(username);
		} else {
			bill = new Bill();

			bill.setCreatedDate(now);
			bill.setCreatedBy(username);
			bill.setUpdatedDate(now);
			bill.setUpdatedBy(username);
		}

		bill.setAddress(billRequest.getAddress());
		bill.setCity(billRequest.getCity());
		bill.setPayment(billRequest.getPayment());
		bill.setPhoneNumber(billRequest.getPhoneNumber());
		bill.setStatus(billStatusRepository.findByBillStatus(EBillStatus.UNPAIR)
				.orElseThrow(() -> new RuntimeException("BillStatus not exist!")));
		bill.setTotal(billRequest.getTotal());
		bill.setUser(userRepository.findByUsername(billRequest.getUsername())
				.orElseThrow(() -> new RuntimeException("User not exist!")));

		for (BillDetail billDetail : billRequest.getBillDetails()) {
			Product product = productRepository.findById(billDetail.getProductID())
					.orElseThrow(() -> new RuntimeException("Product not exist!"));
			if (product.getQuantity() >= billDetail.getQuantity()) {
				product.setQuantity(product.getQuantity() - billDetail.getQuantity());
				productRepository.save(product);
			} else {
				return new MessageResponse("Invalid product quantity: " + product.getNameProduct());
			}
		}
		bill.setBillDetails(billRequest.getBillDetails());

		billRepository.save(bill);
		return new MessageResponse("Successfully!");
	}

	@Override
	public MessageResponse updateStatus(String id, EBillStatus status) {
		Bill bill = billRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not exist!"));
		bill.setStatus(billStatusRepository.findByBillStatus(status).get());
		billRepository.save(bill);
		return new MessageResponse("Successfully!");
	}

	@Override
	public MessageResponse delete(String id) {
		Bill bill = billRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not exist!"));
		billRepository.delete(bill);
		return new MessageResponse("Delete successfully!");
	}

}
