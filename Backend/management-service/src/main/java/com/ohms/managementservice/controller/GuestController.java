package com.ohms.managementservice.controller;


import com.ohms.managementservice.Dto.GuestDTO;
import com.ohms.managementservice.entity.Guest;
import com.ohms.managementservice.exception.GuestNotFoundException;
import com.ohms.managementservice.service.GuestService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guest")
@CrossOrigin(origins = {"http://localhost:4200"})
public class GuestController {

    @Autowired
    private final GuestService guestService;


    @PostMapping("/add")
   
    public ResponseEntity<Guest> createUser(@RequestBody @Valid Guest guest) throws Exception {
        Guest g = guestService.addGuest(guest);
        return new ResponseEntity<Guest>(g, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateGuest(@PathVariable Long id, @RequestBody Guest guest) throws GuestNotFoundException {
        guestService.updateGuest(id, guest);
        return ResponseEntity.ok( "Guest updated successfully.");
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<GuestDTO> getGuestById(@PathVariable Long id) throws GuestNotFoundException {
        if(guestService.findIfIdPresent(id)) {
        	GuestDTO gDto = this.guestService.findGuest(id);
            return new ResponseEntity<GuestDTO>(gDto, HttpStatus.OK);
        }
        else {
            throw new GuestNotFoundException("User with Id : "+id+" not found ");
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Guest>> getAllGuest(){
        return new ResponseEntity<List<Guest>>( guestService.getAllGuests(),HttpStatus.OK);
    }

    @DeleteMapping("/deletedById/{guestId}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long guestId) {

        String guest = guestService.deleteGuest(guestId);
        return new ResponseEntity<String>(guest, HttpStatus.OK);

    }

}
