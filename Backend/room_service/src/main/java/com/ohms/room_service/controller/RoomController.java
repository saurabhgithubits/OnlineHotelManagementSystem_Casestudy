package com.ohms.room_service.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.ohms.room_service.entity.Room;
import com.ohms.room_service.exception.NoRoomsAvailableException;
import com.ohms.room_service.service.RoomService;

@RestController
@RequestMapping("/room")
@CrossOrigin(origins = {"http://localhost:9999", "http://localhost:4200"}, allowedHeaders = "*")
public class RoomController {
	
    @Autowired
    private RoomService roomService;

    @GetMapping("/search")
    public List<Room> searchRooms(
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkInDate,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOutDate) {
        return roomService.searchAvailableRooms(checkInDate, checkOutDate);
        
    }
    
    @GetMapping("/type")
    public List<Room> searchRoomsByType(@RequestParam  String roomType) {
        return roomService.searchByType(roomType);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Room> createUser(@RequestBody Room room){
    	Room g = roomService.addRoom(room);
        return new ResponseEntity<Room>(g, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRoom(@PathVariable long id, @RequestBody Room room) throws NoRoomsAvailableException {
        roomService.updateRoom(id, room);
        return ResponseEntity.ok( "Room updated successfully.");
    }
    
    @GetMapping("/get")
    public ResponseEntity<List<Room>> getAllRoom(){
        return new ResponseEntity<List<Room>>( roomService.getAllRoom(),HttpStatus.OK);
    }
    
    
    @GetMapping("/getById/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) throws  NoRoomsAvailableException{
        if(roomService.findIfIdPresent(id)) {
        	Room gDto = this.roomService.findRoom(id);
            return new ResponseEntity<Room>(gDto, HttpStatus.OK);
        }
        else {
            throw new NoRoomsAvailableException("User with Id : "+id+" not found ");
        }
    }

}
