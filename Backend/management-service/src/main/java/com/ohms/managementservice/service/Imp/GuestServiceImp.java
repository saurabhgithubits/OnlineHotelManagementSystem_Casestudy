package com.ohms.managementservice.service.Imp;

import org.modelmapper.ModelMapper;


import com.ohms.managementservice.Dto.GuestDTO;
import com.ohms.managementservice.entity.Guest;
import com.ohms.managementservice.exception.GuestNotFoundException;
import com.ohms.managementservice.repository.GuestRepository;
import com.ohms.managementservice.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestServiceImp implements GuestService {

    private final GuestRepository guestRepository;
    
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Guest addGuest(Guest guest) {
        Guest g = guestRepository.save(guest);
        return g;
    }

    @Override
    public Guest updateGuest(Long id, Guest guest) throws GuestNotFoundException {
        Guest existingGuest = guestRepository.findById(id)
                .orElseThrow(() -> new GuestNotFoundException("Guest not found with id: " + id));
        existingGuest.setName(guest.getName());
        existingGuest.setCompany(guest.getCompany());
        existingGuest.setEmail(guest.getEmail());
        existingGuest.setGender(guest.getGender());
        existingGuest.setAddress(guest.getAddress());
        existingGuest.setPhoneNumber(guest.getPhoneNumber());
             existingGuest.setMemberCode(guest.getMemberCode());
        return guestRepository.save(existingGuest);
    }


    @Override
    public List<Guest> getAllGuests() {
        List<Guest> guest=guestRepository.findAll();
        return guest;
    }

    @Override
    public String deleteGuest(Long id) {

        guestRepository.deleteById(id);
        return "The guest is deleted successfully";
    }
    @Override
    public GuestDTO findGuest(Long id) {
        Guest guest = this.guestRepository.findById(id).get();
        GuestDTO guestDTO = this.modelMapper.map(guest, GuestDTO.class);
        return guestDTO;
    
    }


    @Override
    public boolean findIfIdPresent(Long id) {
        if(guestRepository.findById(id).isPresent())
            return true;
        return false;
    }
}
