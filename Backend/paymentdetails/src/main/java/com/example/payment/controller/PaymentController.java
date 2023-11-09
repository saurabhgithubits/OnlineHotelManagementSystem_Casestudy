package com.example.payment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment.Service.PaymentService;
import com.example.payment.dto.PaymentDto;
import com.example.payment.model.Payment;


@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = {"http://localhost:9092", "http://localhost:4200"}, allowedHeaders = "*")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	
	 
	@GetMapping("/getAllPayment")
	public List<Payment> getAllPayment()
	{
	 return paymentService.getAllpayments();
	}
	
	@PostMapping("/payment")
	public ResponseEntity<String>  createpayment(@RequestBody  @Valid Payment payment)
	{
		 paymentService.createpayment(payment);
		 return ResponseEntity.ok("Payment added successfully.");
		 
	}
	
	@PutMapping("/payment/{id}")
	public ResponseEntity<String> updatereservation(@PathVariable Long id,@RequestBody Payment paymentdetails)
	{
		
		 paymentService.updatepayment(id, paymentdetails);
	        return ResponseEntity.ok("Payment updated successfully.");
		
	}
	@DeleteMapping("/payment/{id}")
	public ResponseEntity<Map<String, Boolean>> deletereservation(@PathVariable Long id)  {
	         paymentService.deletepayment(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	
	
}
