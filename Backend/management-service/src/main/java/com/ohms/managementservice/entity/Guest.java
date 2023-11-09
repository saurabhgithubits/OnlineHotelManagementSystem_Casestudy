package com.ohms.managementservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Guest")
public class Guest {

    public Guest(int i, int j, String string, String string2, String string3, String string4, String string5) {
		// TODO Auto-generated constructor stub
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member-code")
//    @Max(value = 5)
    private String memberCode;
    
    @Size(max = 10, min = 10, message = "Phone number should be 10")
    
    @Column(name = "phoneNumber")
    private String phoneNumber;
    
    @NotEmpty(message = "Company name should not empty")
    @Column(name = "company")
    private String company;
    
    @NotEmpty(message = "Name should not empty")
    @Size(max = 50, min = 2, message = "Name should not empty")
    @Column(name = "name")
    private String name;
    
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Enter the proper email")
    @Column(name = "email")
    @NotEmpty(message = "email should not empty")
    private String email;
    
    @Column(name = "gender")
    @NotEmpty(message = "gender should not empty")
    private String gender;
    
    @NotEmpty(message = "Address should not empty")
    @Size(max = 100, min = 4, message = "Address should not empty")
    @Column(name = "address")
    private String address;
}
