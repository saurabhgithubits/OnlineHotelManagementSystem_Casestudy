package com.ohms.managementservice.Dto;



import jakarta.persistence.Column;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class GuestDTO {
	
    @Column(name = "member-code")
    private String memberCode;   
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "company")
    private String company;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    private String gender;
    @Column(name = "address")
    private String address;

    // Constructors, getters, and setters
}
