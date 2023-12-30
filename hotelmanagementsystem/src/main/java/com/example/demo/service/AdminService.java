package com.example.demo.service;

import com.example.demo.entity.Admin;





public interface AdminService {
	Admin createAdmin(Admin admin);
	
	Admin getAdminById(int id);
	
	void deleteAdmin(int id);
	
	Admin updateAdmin(int id, Admin updatedAdmin);
	
	 Iterable<Admin> getAllAdmin();

}
