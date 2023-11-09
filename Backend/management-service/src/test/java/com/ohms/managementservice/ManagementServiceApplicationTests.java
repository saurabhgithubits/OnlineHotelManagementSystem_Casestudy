package com.ohms.managementservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ohms.managementservice.entity.Guest;
import com.ohms.managementservice.repository.GuestRepository;
import com.ohms.managementservice.service.GuestService;

@SpringBootTest
class ManagementServiceApplicationTests {
	
	@Autowired
	GuestService guestservice;

	@MockBean
	GuestRepository guestRepository;
	
	private Guest guest;


	@Test
	void contextLoads() {
		guest = new Guest();
		
	}
	
	
        @Test	
		public void getAllGuest()
		{
			when(guestRepository.findAll()).thenReturn(Stream.of(new Guest()).collect(Collectors.toList()));

		assertEquals(1,guestservice.getAllGuests().size());
		}
        
    	@Test
    	public void saveguest()
    	{
    		Guest guest=new Guest(1,9847564,"sam","male","email","capg","madurai");
    		when(guestRepository.save(guest)).thenReturn(guest);
    		assertEquals(guest,guestservice.addGuest(guest));
    	}
    	
    	@Test
    	public void deleteguest()
    	{
    	     Long id = 1L;
    	     Guest guest=new Guest(1,9847564,"sam","male","email","capg","madurai");
    	        guest.setId(id);

    	        when(guestRepository.findById(id)).thenReturn(Optional.of(guest));

    	        guestservice.deleteGuest(id);   
    	        verify(guestRepository,times(1)).delete(guest);
    	}
    	
    	@Test
        public void testFindIfIdPresent() {
            Long id = 1L;
            Mockito.when(guestRepository.findById(id)).thenReturn(Optional.of(new Guest())); // Mock repository find
            assertTrue(guestservice.findIfIdPresent(id));
        }

        @Test
        public void testFindIfIdNotPresent() {
            Long id = 1L;
            Mockito.when(guestRepository.findById(id)).thenReturn(Optional.empty()); // Mock repository find
            assertFalse(guestservice.findIfIdPresent(id));
        }
}

