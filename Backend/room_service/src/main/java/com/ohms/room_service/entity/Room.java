package com.ohms.room_service.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {

	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private long id;
	   
	    
	    private String roomType;
	    private LocalDate checkInDate;
	    private LocalDate checkOutDate;
}
