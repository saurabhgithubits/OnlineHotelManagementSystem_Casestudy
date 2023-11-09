package com.ohms.managementservice;

import org.junit.jupiter.api.Test;

import com.ohms.managementservice.Dto.GuestDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuestDTOTest {

    @Test
    public void testNoArgsConstructor() {
        GuestDTO guestDTO = new GuestDTO();
        assertEquals(null, guestDTO.getMemberCode());
        assertEquals(null, guestDTO.getPhoneNumber());
        assertEquals(null, guestDTO.getCompany());
        assertEquals(null, guestDTO.getName());
        assertEquals(null, guestDTO.getEmail());
        assertEquals(null, guestDTO.getGender());
        assertEquals(null, guestDTO.getAddress());
    }

    @Test
    public void testAllArgsConstructor() {
        GuestDTO guestDTO = new GuestDTO("12345", "555-555-5555", "Company", "John Doe", "johndoe@example.com", "Male", "123 Main St");
        assertEquals("12345", guestDTO.getMemberCode());
        assertEquals("555-555-5555", guestDTO.getPhoneNumber());
        assertEquals("Company", guestDTO.getCompany());
        assertEquals("John Doe", guestDTO.getName());
        assertEquals("johndoe@example.com", guestDTO.getEmail());
        assertEquals("Male", guestDTO.getGender());
        assertEquals("123 Main St", guestDTO.getAddress());
    }

    @Test
    public void testGettersAndSetters() {
        GuestDTO guestDTO = new GuestDTO();
        guestDTO.setMemberCode("67890");
        guestDTO.setPhoneNumber("555-123-4567");
        guestDTO.setCompany("New Company");
        guestDTO.setName("Jane Doe");
        guestDTO.setEmail("janedoe@example.com");
        guestDTO.setGender("Female");
        guestDTO.setAddress("456 Elm St");

        assertEquals("67890", guestDTO.getMemberCode());
        assertEquals("555-123-4567", guestDTO.getPhoneNumber());
        assertEquals("New Company", guestDTO.getCompany());
        assertEquals("Jane Doe", guestDTO.getName());
        assertEquals("janedoe@example.com", guestDTO.getEmail());
        assertEquals("Female", guestDTO.getGender());
        assertEquals("456 Elm St", guestDTO.getAddress());
    }
}
