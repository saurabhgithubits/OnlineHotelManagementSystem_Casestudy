package com.example.reservation.DTO;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReservationDTO {

   

	@Column(name="no_of_adult")
	
    int no_of_Adult;
	@Column(name="no_of_child")
	
    int no_of_child;
	@Column(name="checkin_date")

    String check_in_date;
	
	@Column(name="checkout_date")
	
    String checkout_date;
	@NotNull(message="adult_details cannot be blank")

	@Column(name="Status")
    String Status;

	@Column(name="noOfNights")
    long noOfNights;
}