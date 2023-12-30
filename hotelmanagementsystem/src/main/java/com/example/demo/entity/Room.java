package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Room_Id")
	private int id;
	
	@Column(name = "RoomNumber", length = 40,unique=true)
    @NotNull(message="Room Number can't be Empty.")
	@Pattern(regexp="^[0-9]+$",message="Only Numeric Values are Allowed.")
	@Size(min=1,max=40,message="Minimum 1 and maximum 40 characters allowed.")
	private String roomNumber;
	
	@Column(name = "Room capacity", length = 40)
   @NotNull(message="capacity can't be Empty.")
	private int capacity;
	
	
	  @ManyToMany(mappedBy = "rooms")
	    private List<Customer> customers = new ArrayList<>();
	
	
	
	
	
	
	
}
