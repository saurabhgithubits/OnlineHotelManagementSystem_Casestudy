package com.example.reservation.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reservation.DTO.ReservationDTO;
import com.example.reservation.Service.ReservationService;
import com.example.reservation.exception.ResourceNotFoundException;
import com.example.reservation.model.Reservation;
import com.example.reservation.repository.Reservationrepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	Reservationrepository reservationrepository;
	 @Autowired
	  ModelMapper modelMapper;
	@Override
	public List<Reservation> getAllreservations() {
		// TODO Auto-generated method stub
		return reservationrepository.findAll();
	}
	private ReservationDTO ConvertEntityToDto(Reservation reservation)
	{
		ReservationDTO reservationdto=new ReservationDTO();
		reservationdto=modelMapper.map(reservation,ReservationDTO.class);
		return reservationdto;
	}	
		
	
	

	@Override
	public ReservationDTO createreservation(Reservation reservation) {
		// TODO Auto-generated method stub
		//  Reservation reservation = new Reservation();
	   //     BeanUtils.copyProperties(reservationdto, reservation);
	        Reservation reservations= reservationrepository.save(reservation);
	        return ConvertEntityToDto(reservations);
	}

	@Override
	public ReservationDTO updatereservation(Long id, Reservation reservationdetails) {
		
		Reservation reservation=reservationrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("id not exist:" + id));
			     
				 reservation.setNo_of_Adult( reservationdetails.getNo_of_Adult());
				 reservation.setNo_of_child( reservationdetails.getNo_of_Adult());
				 reservation.setCheck_in_date( reservationdetails.getCheck_in_date());
				 reservation.setCheckout_date( reservationdetails.getCheckout_date());
				 reservation.setStatus( reservationdetails.getStatus());
				 reservation.setNoOfNights(reservationdetails.getNoOfNights());
				
				 Reservation reservations= reservationrepository.save(reservation);
				 
				 return ConvertEntityToDto(reservations);

					}


	@Override
	public String deleteReserve(Long id) {
		reservationrepository.deleteById(id);
        return "The guest is deleted successfully";
	}
	
	 @Override
	    public Reservation findReservation(Long id) {
		 Reservation r = reservationrepository.findById(id).get();
	       
	        return r;
	    
	    }


	    @Override
	    public boolean findIfIdPresent(Long id) {
	        if(reservationrepository.findById(id).isPresent())
	            return true;
	        return false;
	    }

}
