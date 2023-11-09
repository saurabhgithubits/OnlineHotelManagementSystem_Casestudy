package com.example.staff.dto;

import javax.persistence.Column;



import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Staffdto {
	@Column(name="Name")
	private String name;
	@Column(name="Address")
	private String address;
	@Column(name="Salary")
	private int Salary;
	@Column(name="Occupation")
	private String Occupation;
	@Column(name="Email")
	private String email;
}
