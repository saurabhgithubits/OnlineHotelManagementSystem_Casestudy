package com.example.staff.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.staff.Service.StaffService;
import com.example.staff.dto.Staffdto;
import com.example.staff.exception.ResourceNotFoundException;
import com.example.staff.model.Staff;


@RestController
@RequestMapping("/staff")
@CrossOrigin(origins = {"http://localhost:4200"})
public class StaffController {

	@Autowired
	StaffService staffservice;
	@GetMapping("/get")
	public List<Staff> getAllstaff()
	{
	return staffservice.getAllStaffs();
	}
	@PostMapping("/add")
	public ResponseEntity<String> createStaff(@RequestBody @Valid Staff staff)
	{
		staffservice.createStaff(staff);
		return ResponseEntity.ok("Staff details added successfully");
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updatestaff(@PathVariable Long id, @Valid @RequestBody Staff staffdetails)throws ResourceNotFoundException
	{
		
		
	

		 staffservice.updateStaff(id, staffdetails);
		return ResponseEntity.ok("Staff details updated successfully");
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable Long id) {

        String g = staffservice.deleteStaff(id);
        return new ResponseEntity<String>(g, HttpStatus.OK);

    }
	
    @GetMapping("/getById/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long id) throws  ResourceNotFoundException{
        if(staffservice.findIfIdPresent(id)) {
        	Staff gDto = this.staffservice.findStaff(id);
            return new ResponseEntity<Staff>(gDto, HttpStatus.OK);
        }
        else {
            throw new ResourceNotFoundException("User with Id : "+id+" not found ");
        }
    }
}
