package com.ohms.managementservice;

import com.ohms.managementservice.Dto.GuestDTO;
import com.ohms.managementservice.controller.GuestController;
import com.ohms.managementservice.entity.Guest;
import com.ohms.managementservice.exception.GuestNotFoundException;
import com.ohms.managementservice.service.GuestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GuestControllerTest {

    @InjectMocks
    private GuestController guestController;

    @Mock
    private GuestService guestService;

    private Guest testGuest;

    @BeforeEach
    void setUp() {
        testGuest = new Guest(); // Initialize with test data
    }

    @Test
    public void testCreateUser() throws Exception {
        Mockito.when(guestService.addGuest(Mockito.any(Guest.class))).thenReturn(testGuest);

        ResponseEntity<Guest> response = guestController.createUser(testGuest);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(testGuest, response.getBody());
    }

    @Test
    public void testUpdateGuest() throws GuestNotFoundException {
        Long guestId = 1L;

        ResponseEntity<String> response = guestController.updateGuest(guestId, testGuest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Guest updated successfully.", response.getBody());
    }

    @Test
    public void testGetGuestById() throws GuestNotFoundException {
        Long guestId = 1L;
        GuestDTO guestDTO = new GuestDTO(); // Initialize with test data

        Mockito.when(guestService.findIfIdPresent(guestId)).thenReturn(true);
        Mockito.when(guestService.findGuest(guestId)).thenReturn(guestDTO);

        ResponseEntity<GuestDTO> response = guestController.getGuestById(guestId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(guestDTO, response.getBody());
    }

    @Test
    public void testGetGuestByIdGuestNotFound() {
        Long guestId = 1L;

        Mockito.when(guestService.findIfIdPresent(guestId)).thenReturn(false);

        try {
            guestController.getGuestById(guestId);
        } catch (GuestNotFoundException e) {
            assertEquals("User with Id : " + guestId + " not found", e.getMessage());
        }
    }

    @Test
    public void testGetAllGuest() {
        List<Guest> guestList = Arrays.asList(testGuest); // Initialize with test data

        Mockito.when(guestService.getAllGuests()).thenReturn(guestList);

        ResponseEntity<List<Guest>> response = guestController.getAllGuest();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(guestList, response.getBody());
    }

    @Test
    public void testDeleteUserById() {
        Long guestId = 1L;

        Mockito.when(guestService.deleteGuest(guestId)).thenReturn("Guest deleted successfully.");

        ResponseEntity<String> response = guestController.deleteUserById(guestId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Guest deleted successfully.", response.getBody());
    }
}
