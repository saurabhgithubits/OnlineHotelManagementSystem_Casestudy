package com.example.reservation.Service;

import java.util.List;


import com.example.reservation.DTO.ReservationDTO;
import com.example.reservation.model.Reservation;

public interface ReservationService {
	List<Reservation> getAllreservations();
	ReservationDTO createreservation(Reservation reservation);
	ReservationDTO updatereservation( Long id,Reservation reservationdetails);
	
	String deleteReserve(Long id);
	boolean findIfIdPresent(Long id);
	Reservation findReservation(Long id);
	
	
	
	
	
}
