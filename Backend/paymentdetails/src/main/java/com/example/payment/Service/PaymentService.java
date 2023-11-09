package com.example.payment.Service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.payment.dto.PaymentDto;
import com.example.payment.model.Payment;


public interface PaymentService {
	List<Payment> getAllpayments();
	PaymentDto createpayment(Payment payment);
	
	void deletepayment( Long id);
	PaymentDto updatepayment(Long id, Payment paymentdetails);
	
	
	
	
	
	
}
