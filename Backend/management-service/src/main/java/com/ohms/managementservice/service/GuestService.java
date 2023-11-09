package com.ohms.managementservice.service;

import com.ohms.managementservice.Dto.GuestDTO;
import com.ohms.managementservice.entity.Guest;
import com.ohms.managementservice.exception.GuestNotFoundException;

import java.util.List;

public interface GuestService  {

    Guest addGuest(Guest guest);
    Guest updateGuest(Long id, Guest guest) throws GuestNotFoundException;
    GuestDTO findGuest(Long id);
    List<Guest> getAllGuests();
    String deleteGuest(Long id);

    boolean findIfIdPresent(Long id);
}
