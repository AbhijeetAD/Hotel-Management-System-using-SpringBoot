package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Room;
import com.example.demo.exceptionhandling.AdminNotFoundException;
import com.example.demo.exceptionhandling.CustomerNotFoundException;
import com.example.demo.exceptionhandling.RoomNotFoundException;
import com.example.demo.service.AdminService;
import com.example.demo.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class AdminController {
	
	 @Autowired
	    private AdminService adminService;

	    @PostMapping("/admin")
	    public ResponseEntity<Admin> createAdmin(@RequestBody  Admin admin) {
	        Admin createdAdmin = adminService.createAdmin(admin);
	        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
	    }
	    
	    @DeleteMapping("/admin/{id}")
	    public ResponseEntity<Void> deleteAdmin(@PathVariable int id) {
	        adminService.deleteAdmin(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    @GetMapping("/admin/{id}")
	    public ResponseEntity<Admin> getAdminById(@PathVariable int id) {
	        try {
	            Admin admin = adminService.getAdminById(id);
	            return new ResponseEntity<>(admin, HttpStatus.OK);
	        } catch (AdminNotFoundException ex) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PutMapping("/admin/{id}")
	    public ResponseEntity<Admin> updateAdmin(
	            @PathVariable int id,
	            @Valid @RequestBody Admin updateAdmin) {
	        try {
	            Admin updated = adminService.updateAdmin(id, updateAdmin);
	            return new ResponseEntity<>(updated, HttpStatus.OK);
	        } catch (AdminNotFoundException ex) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    @GetMapping("/admins")
	    public ResponseEntity<Iterable<Admin>> getAllAdmin() {
	        Iterable<Admin> admin = adminService.getAllAdmin();
	        return new ResponseEntity<>(admin, HttpStatus.OK);
	    }
}
