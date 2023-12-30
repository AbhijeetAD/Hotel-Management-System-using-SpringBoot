package com.example.demo.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingid",unique=true)
    private int id;
    
    @Column(name = "check_in_date")
    @Temporal(TemporalType.DATE)
    private Date checkInDate;
    
    @Column(name = "check_out_date")
    @Temporal(TemporalType.DATE)
      private Date checkOutDate;
    
    @Column(name = "NumOfChildren")
     private int numberOfChildren;
    
    @Column(name = "Adults")
    private int adults;
    
    @Column(name="Breakfast")
    private boolean breakfastIncluded;
    
    @Column(name = "RoomNumber",unique = true)
    private int roomNumber;
    
    @Column(name = "FinalTotalCost")
    private double totalCost;
    

    public void calculateTotalCost() {
        double baseCost = 2500.0;
        this.totalCost = baseCost;

        // If there are children, add 500 for the first child and 500 for each additional child
        if (this.numberOfChildren > 0) {
            double childrenCost = 500.0 + (this.numberOfChildren - 1) * 500.0;
            this.totalCost += childrenCost;

            
        }

        // If breakfast is included, add 300
        if (this.breakfastIncluded) {
            double breakfastCost = 300.0;
            this.totalCost += breakfastCost;
        }
    }
    }


    
    

