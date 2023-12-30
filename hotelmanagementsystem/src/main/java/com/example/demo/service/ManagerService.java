package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.Manager;
import com.example.demo.exceptionhandling.ManagerNotFoundException;

public interface ManagerService {

	 Manager createManager(Manager manager);

	    Manager updateManager(int managerId, Manager updatedManager);

	    void deleteManager(int managerId);

	    Manager getManagerById(int managerId);

	    Iterable<Manager> getAllManagers();
}
