package com.example.reservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name="reservation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    long id;
	@Column(name="no_of_adult")
	
	 
	 @Max(value=3, message = "Adult value should not be greater than 3")
	long no_of_Adult;
	@Column(name="no_of_child")
	
	 @Max(value=3, message = "child value should not be greater than 3")
    long no_of_child;
	@Column(name="checkin_date")
	@NotBlank(message="check_in_date cannot be blank")
    String check_in_date;
	@NotBlank(message="check_in_date cannot be blank")
	@Column(name="checkout_date")
    String checkout_date;
	
	@Column(name="Status")
    String Status;
	
	@Column(name="noOfNights")
    long noOfNights;
	
	
}
