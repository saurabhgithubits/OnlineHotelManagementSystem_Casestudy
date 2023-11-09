package com.example.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.reservation.DTO.ReservationDTO;
import com.example.reservation.Service.ReservationService;
import com.example.reservation.exception.ResourceNotFoundException;
import com.example.reservation.model.Reservation;


@RestController
@RequestMapping("/reserve")
@CrossOrigin(origins = {"http://localhost:4200"})

public class ReservationController {

	@Autowired
	ReservationService reservationService;
	
	
	 
	@GetMapping("/get")
	public List<Reservation> getAllreservations()
	{
	 
		List<Reservation> l= reservationService.getAllreservations();
		return l;
	}
	
	@PostMapping("/add")
	public ResponseEntity<String>  createreservation(@RequestBody @Valid Reservation reservation)
	{
		 reservationService.createreservation(reservation);
		 return ResponseEntity.ok("Reservation added successfully.");
		 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updatereservation(@PathVariable Long id,@Valid @RequestBody Reservation reservationdetails)
	{
		
		 reservationService.updatereservation(id, reservationdetails);
		 
	        return ResponseEntity.ok("Reservation updated successfully.");
		
	}
	 @DeleteMapping("/deletedById/{id}")
	    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {

	        String r = reservationService.deleteReserve(id);
	        return new ResponseEntity<String>(r, HttpStatus.OK);

	    }

	  @GetMapping("/getById/{id}")
	    public ResponseEntity<Reservation> getGuestById(@PathVariable Long id) throws ResourceNotFoundException {
	        if(reservationService.findIfIdPresent(id)) {
	        	Reservation gDto = this.reservationService.findReservation(id);
	            return new ResponseEntity<Reservation>(gDto, HttpStatus.OK);
	        }
	        else {
	            throw new ResourceNotFoundException("User with Id : "+id+" not found ");
	        }
	    }
	
	
}
