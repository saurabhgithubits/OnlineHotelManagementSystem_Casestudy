package com.ohms.room_service.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ohms.room_service.entity.Room;

public interface RoomService {

	Room addRoom(Room room);

	List<Room> getAllRoom();

	List<Room> searchAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate);

	List<Room> searchByType(String type);
	
	Room updateRoom(long id, Room room);

	Room findRoom(Long id);

	boolean findIfIdPresent(Long id);

}
