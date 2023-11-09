package com.example.payment.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {


	
	@Column(name="cardHolderName")
	 String cardHolderName;
	@Column(name="cardNumber")
	 long cardNumber;
	@Column(name="expirationDate")
	 String expirationDate;
	@Column(name="amount")
	 long amount;

	
}
