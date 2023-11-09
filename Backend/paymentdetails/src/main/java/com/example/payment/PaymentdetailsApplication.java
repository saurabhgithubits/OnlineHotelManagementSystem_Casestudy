package com.example.payment;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@EnableDiscoveryClient
@ComponentScan(basePackages= {"com.*"})
public class PaymentdetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentdetailsApplication.class, args);
	}
	@Bean
    public ModelMapper getModelMapper() {
       return  new ModelMapper();
    }
}
