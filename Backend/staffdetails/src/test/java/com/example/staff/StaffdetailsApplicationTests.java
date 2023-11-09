package com.example.staff;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
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


import com.example.staff.Service.StaffService;
import com.example.staff.dto.Staffdto;
import com.example.staff.model.Staff;
import com.example.staff.repository.StaffRepository;

@SpringBootTest
class StaffdetailsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	StaffService staffservice;
	
	@MockBean
	StaffRepository staffRepository;
	
	@Test
	public void getAllStaff()
	{
		when(staffRepository.findAll()).thenReturn(Stream.of(new Staff((long) 1,"sam","madurai",1000,"chef","sam@gmail.com")).collect(Collectors.toList()));
	
	assertEquals(1,staffservice.getAllStaffs().size());
	}
	@Test
public void saveguest()
{
	Staff staff=new Staff((long) 1,"sam","madurai",1000,"chef","sam@gmail.com");
	when(staffRepository.save(staff)).thenReturn(staff);
	Staffdto staffdto=new Staffdto("sam","madurai",1000,"chef","sam@gmail.com");
	assertEquals(staffdto,staffservice.createStaff(staff));
}
	@Test
	public void deleteguest()
	{
	     Long id = 1L;
	     Staff staff=new Staff((long) 1,"sam","madurai",1000,"chef","sam@gmail.com");
	        staff.setId(id);



	        when(staffRepository.findById(id)).thenReturn(Optional.of(staff));



	        staffservice.deleteStaff(id);



	        // Verify that the deleteReservation method was called successfully
	        // For example, you could check if the reservation was deleted or not
	        verify(staffRepository,times(1)).delete(staff);
	}
	   @Test
	    void updateStaff() {
		   Staff staff= spy(new Staff((long) 1,"sam","madurai",1000,"chef","sam@gmail.com"));
	        Long id = 1L;

	       

	        // Initially, it will use the actual method behavior
	        assertEquals(id, staff.getId());

	        // Update the behavior of the method
	        doReturn((long)3).when(staff).getId();

	        // Now, it will return the updated value
	        assertEquals((long)3,  staff.getId());
	       
	        
	    }
}