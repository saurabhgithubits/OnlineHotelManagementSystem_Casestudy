package com.example.reservation;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.reservation.DTO.ReservationDTO;
import com.example.reservation.Service.ReservationService;
import com.example.reservation.model.Reservation;
import com.example.reservation.repository.Reservationrepository;


@SpringBootTest
class ReservationdetailsApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	ReservationService reservationservice;
	
	@MockBean
	Reservationrepository reservationrepository;
	
	@Test
	public void getAllreservations()
	{
		when(reservationrepository.findAll()).thenReturn(Stream.of(new Reservation(1,5,6,"23","25","pending",3)).collect(Collectors.toList()));
	
	assertEquals(1,reservationservice.getAllreservations().size());
	}
	@Test
public void savereservations()
{
	Reservation reservation=new Reservation(1,5,6,"23","25","pending",3);
	
	when(reservationrepository.save(reservation)).thenReturn(reservation);
	ReservationDTO reservations=new ReservationDTO(5,6,"23","25","pending",3);
	assertEquals(reservations,reservationservice.createreservation(reservation));
}
	@Test
	public void deleteguest()
	{
	     Long id = 1L;
	     Reservation reservation=new Reservation(1,5,6,"23","25","pending",3);
	        reservation.setId(id);



	        when(reservationrepository.findById(id)).thenReturn(Optional.of(reservation));



	        //reservationservice.deletereservation(id);



	        // Verify that the deleteReservation method was called successfully
	        // For example, you could check if the reservation was deleted or not
	        verify(reservationrepository,times(1)).delete(reservation);
	}
	@Test
	public void updatereservations() {
		   Reservation reservation= spy(new Reservation(1,5,6,"23","25","pending",3));
	        Long id = 1L;

	       

	        // Initially, it will use the actual method behavior
	        assertEquals(id,reservation.getId());

	        // Update the behavior of the method
	        doReturn((long)3).when(reservation).getId();

	        // Now, it will return the updated value
	        assertEquals((long)3, reservation.getId());
	        System.out.println(reservation.getId());
	        
	    }
}
