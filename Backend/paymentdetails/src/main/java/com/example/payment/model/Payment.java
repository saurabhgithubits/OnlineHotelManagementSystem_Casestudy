package com.example.payment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 long id;
	
	  @NotBlank(message = "Please enter the name")
	@Column(name="cardHolderName")
	 String cardHolderName;

	@Column(name="cardNumber")
	 long cardNumber;
	
	  @NotBlank(message = "Please enter the exp_date")
	@Column(name="expirationDate")
	 String expirationDate;

	@Column(name="amount")
	@NotBlank(message = "Please enter the amount")
	 long amount;
	
	
	
}
