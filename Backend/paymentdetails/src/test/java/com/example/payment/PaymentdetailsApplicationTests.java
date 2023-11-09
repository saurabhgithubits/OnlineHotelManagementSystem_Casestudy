package com.example.payment;

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

import com.example.payment.Service.PaymentService;
import com.example.payment.dto.PaymentDto;
import com.example.payment.model.Payment;
import com.example.payment.repository.PaymentRepository;


@SpringBootTest
class PaymentdetailsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	PaymentService paymentservice;
	
	@MockBean
	PaymentRepository paymentRepository;
	
//	@Test
//	public void getAllStaff()
//	{
//		when(paymentRepository.findAll()).thenReturn(Stream.of(new Payment((long) 1,"sam",365384065,"chef",56,"sam@gmail.com")).collect(Collectors.toList()));
//	
//	assertEquals(1,paymentservice.getAllpayments().size());
//	}
//	@Test
//public void savepayment()
//{
//Payment  payment=new Payment((long) 1,"sam",365384065,"chef",56,"sam@gmail.com");
//	when(paymentRepository.save(payment)).thenReturn(payment);
//	PaymentDto paymentdto=new PaymentDto("sam",365384065,"chef",56,"sam@gmail.com");
//	assertEquals(paymentdto,paymentservice.createpayment(payment));
//}
//	@Test
//	public void deletepayment()
//	{
//	     Long id = 1L;
//	     Payment  payment=new Payment((long) 1,"sam",365384065,"chef",56,"sam@gmail.com");
//payment.setId(id);
//
//
//
//	        when(paymentRepository.findById(id)).thenReturn(Optional.of(payment));
//
//
//
//	        paymentservice.deletepayment(id);
//
//
//
//	        // Verify that the deleteReservation method was called successfully
//	        // For example, you could check if the reservation was deleted or not
//	        verify(paymentRepository,times(1)).delete(payment);
//	}
//	   @Test
//	    void updateStaff() {
//		   Payment payment= spy(new Payment((long) 1,"sam",365384065,"chef",56,"sam@gmail.com"));
//	        Long id = 1L;
//
//	       
//
//	        // Initially, it will use the actual method behavior
//	        assertEquals(id, payment.getId());
//
//	        // Update the behavior of the method
//	        doReturn((long)3).when(payment).getId();
//
//	        // Now, it will return the updated value
//	        assertEquals((long)3,  payment.getId());
//	        
//	        
//	    }

}
