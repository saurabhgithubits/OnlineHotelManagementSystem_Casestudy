package com.example.staff.Service;

import java.util.List;

import com.example.staff.dto.Staffdto;
import com.example.staff.model.Staff;


public interface StaffService {
	List<Staff> getAllStaffs();
	Staffdto createStaff(Staff staff);
	Staffdto updateStaff(Long id,Staff staffdetails);
	String deleteStaff(Long id);
	boolean findIfIdPresent(Long id);
	Staff findStaff(Long id);
	
}
