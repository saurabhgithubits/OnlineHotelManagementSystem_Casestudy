package com.ohms.room_service.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ohms.room_service.entity.Room;
import com.ohms.room_service.exception.NoRoomsAvailableException;
import com.ohms.room_service.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public Room addRoom(Room room) {
		// TODO Auto-generated method stub
		return roomRepository.save(room);
		
	}

	@Override
	public Room updateRoom(long id, Room room) {
		// TODO Auto-generated method stub

		Room update = roomRepository.findById(id)
				.orElseThrow(() -> new NoRoomsAvailableException("No room available with this " + id));

		update.setCheckInDate(room.getCheckInDate());
		update.setCheckOutDate(room.getCheckOutDate());
	
		return roomRepository.save(update);
	}

	@Override
	public List<Room> getAllRoom() {
		// TODO Auto-generated method stub
		List<Room> l = roomRepository.findAll();
		return l;
	}

	@Override
	public List<Room> searchAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate) {
		return roomRepository.findAllByCheckInDateLessThanEqualAndCheckOutDateGreaterThanEqual(checkOutDate,
				checkInDate);
	}
	
	@Override
    public Room findRoom(Long id) {
	 Room r = roomRepository.findById(id).get();
       
        return r;
    
    }


    @Override
    public boolean findIfIdPresent(Long id) {
        if(roomRepository.findById(id).isPresent())
            return true;
        return false;
    }

	@Override
	public List<Room> searchByType(String type) {
		return roomRepository.findRoomsByType(type);
	}

}
