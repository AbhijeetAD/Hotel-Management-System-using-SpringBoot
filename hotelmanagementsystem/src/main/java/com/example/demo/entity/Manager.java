package com.example.demo.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
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
@Table(name="Manager")
public class Manager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "Manager_Name", length = 40)
    @NotNull(message="Manager name can't be Empty.")
    @Size(min=2,max=40,message="Minimum 2 and maximum 40 characters allowed.")
	private String managerName;
	
	@Column(name = "Email", length = 40,unique=true)
    @NotNull(message="Email can't be Empty.")
	@Size(min=6,max=40,message="Minimum 6 and maximum 40 characters allowed.")
	private String email;
	
	@Column(name = "Mobile_No", length = 10,unique=true)
    @NotNull(message="Mobile_No can't be Empty.")
	private long phoneNumber;
	
	
	
	
	
}