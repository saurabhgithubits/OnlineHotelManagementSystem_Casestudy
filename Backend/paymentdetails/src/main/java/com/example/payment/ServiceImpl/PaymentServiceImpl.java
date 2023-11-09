package com.example.payment.ServiceImpl;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payment.Service.PaymentService;
import com.example.payment.dto.PaymentDto;
import com.example.payment.exception.ResourceNotFoundException;
import com.example.payment.model.Payment;
import com.example.payment.repository.PaymentRepository;


@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	PaymentRepository paymentrepository;
	
	 @Autowired
	  ModelMapper modelMapper;

	private PaymentDto ConvertEntityToDto(Payment payment)
	{
		PaymentDto paymentdto=new PaymentDto();
		paymentdto=modelMapper.map(payment,PaymentDto.class);
		return paymentdto;
	}	
		
	
	

	@Override
	public PaymentDto createpayment(Payment payment) {
		// TODO Auto-generated method stub
		 // Payment payment = new Payment();
	       // BeanUtils.copyProperties(paymentdto, payment);
	        Payment payments= paymentrepository.save(payment);
			return ConvertEntityToDto(payments);
	}

	@Override
	public PaymentDto updatepayment(Long id, Payment paymentdetails) {
		
		Payment payment= paymentrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" id not exist :" + id));
			     payment.setCardHolderName(paymentdetails.getCardHolderName());
			     payment.setCardNumber(payment.getCardNumber());
			   	
			     payment.setExpirationDate(paymentdetails.getExpirationDate());
			     payment.setAmount(paymentdetails.getAmount());
			     Payment payments= paymentrepository.save(payment);
					return ConvertEntityToDto(payments);
				 
					}

	@Override
	public void deletepayment(Long id) {
		// TODO Auto-generated method 
		Payment payment= paymentrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" id not exist :" + id));

	paymentrepository.delete(payment);
	}




	@Override
	public List<Payment> getAllpayments() {
		
		return paymentrepository.findAll();
	}

}
