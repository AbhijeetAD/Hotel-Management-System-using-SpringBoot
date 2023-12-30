package com.example.demo.entity;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Hotel")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	
	@Column(name = "Address", length = 50)
    @NotNull(message="Address can't be Empty.")
	@Size(min=3,max=50,message="Minimum 3 and maximum 50 characters allowed.")
	 private String address;
	
	@Column(name = "Hotel_Name", length = 40,unique=true)
    @NotNull(message="Hotel Name can't be Empty.")
	@Size(min=3,max=40,message="Minimum 3 and maximum 40 characters allowed.")
	private String hotelName;
	
	@Column(name = "Hotel_Number", length = 40,unique=true)
    @NotNull(message="Hotel Number can't be Empty.")
	private String phoneNumber;
	
	
	
}
