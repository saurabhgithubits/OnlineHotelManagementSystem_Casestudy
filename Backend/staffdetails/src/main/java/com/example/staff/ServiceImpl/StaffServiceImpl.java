package com.example.staff.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.staff.Service.StaffService;
import com.example.staff.dto.Staffdto;
import com.example.staff.exception.ResourceNotFoundException;
import com.example.staff.model.Staff;
import com.example.staff.repository.StaffRepository;
@Service
public class StaffServiceImpl implements StaffService {

	
	 @Autowired
	  ModelMapper modelMapper;
	 
	 @Autowired
	StaffRepository staffrepository;
	@Override
	public List<Staff> getAllStaffs() {
		// TODO Auto-generated method stub
		return staffrepository.findAll();
	}
	private Staffdto ConvertEntityToDto(Staff staff)
	{
		 Staffdto staffdto=new Staffdto();
		 staffdto=modelMapper.map(staff,Staffdto.class);
		return staffdto;
	}	

	@Override
	public Staffdto createStaff(Staff staffs) {
		// TODO Auto-generated method stub
	//	  Staff staff = new Staff();
	  //      BeanUtils.copyProperties(staffdto, staff);
	        Staff staff= staffrepository.save( staffs);
	        return ConvertEntityToDto( staff);
	}

	@Override
	public Staffdto updateStaff(Long id, Staff staffdetails) {
		// TODO Auto-generated method stub

		Staff staff=staffrepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Staff not exist with id :" + id));
	     staff.setName(staffdetails.getName());
	     staff.setAddress(staffdetails.getAddress());
	     staff.setSalary(staffdetails.getSalary());
	     staff.setOccupation(staffdetails.getOccupation());
	     staff.setEmail(staffdetails.getEmail());
		
		
	

		Staff staffs= staffrepository.save(staff);
		return ConvertEntityToDto( staffs);
		
	}
	@Override
	public String deleteStaff(Long id) {
		staffrepository.deleteById(id);
		return "staff deleted!!";
	}

	 @Override
	    public Staff findStaff(Long id) {
		 Staff r = staffrepository.findById(id).get();
	       
	        return r;
	    
	    }


	    @Override
	    public boolean findIfIdPresent(Long id) {
	        if(staffrepository.findById(id).isPresent())
	            return true;
	        return false;
	    }
	
}
