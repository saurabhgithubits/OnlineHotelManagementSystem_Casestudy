package com.example.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.modelmapper.ModelMapper;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages= {"com.*"})
public class ReservationdetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationdetailsApplication.class, args);
	}
	@Bean
    public ModelMapper getModelMapper() {
       return  new ModelMapper();
    }
}
