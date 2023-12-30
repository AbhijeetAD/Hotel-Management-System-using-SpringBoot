package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Room;
import com.example.demo.exceptionhandling.AdminNotFoundException;
import com.example.demo.exceptionhandling.CustomerNotFoundException;
import com.example.demo.exceptionhandling.RoomNotFoundException;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.AdminService;
import com.example.demo.service.CustomerService;


	
	@Service
	public class AdminServiceImpl implements AdminService {

	    @Autowired
	    private AdminRepository adminRepository;

		@Override
		public Admin createAdmin(Admin admin) {
			// TODO Auto-generated method stub
			 return adminRepository.save(admin);
		}

		@Override
		public Admin getAdminById(int id) {
			return adminRepository.findById(id)
	                .orElseThrow(() -> new AdminNotFoundException(id));
		}

		@Override
		public void deleteAdmin(int id) {
			// TODO Auto-generated method stub
			adminRepository.deleteById(id);
		}

		@Override
		public Iterable<Admin> getAllAdmin() {
			// TODO Auto-generated method stub
		return adminRepository.findAll();
		}

		@Override
	    public Admin updateAdmin(int id, Admin updatedAdmin) {
	        Admin existingAdmin = adminRepository.findById(id).orElse(null);

	        if (existingAdmin != null) {
	            existingAdmin.setPassword(updatedAdmin.getPassword());
	            existingAdmin.setUsername(updatedAdmin.getUsername());

	            // Update other room-related fields as needed

	            return adminRepository.save(existingAdmin);
	        } else {
	            throw new AdminNotFoundException(id);
	        }
	    }
}
